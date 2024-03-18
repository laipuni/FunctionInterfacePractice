package practice.functioninterfacepractice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class CustomSupplierTest {

    @DisplayName("Supplier는 인자 없이 T를 반환한다.")
    @Test
    void CustomSupplier(){
        //given
        String inputString = "CustomSupplier";
        CustomSupplier<String> customSupplier = () -> inputString;

        //when
        String customSupplierReturn = customSupplier.get();

        //then
        assertThat(customSupplierReturn).isEqualTo(inputString);
    }

    @DisplayName("Supplier는 불필요한 연산을 지연시킬 수 있다.")
    @TestFactory
    Stream<DynamicTest> LazyEvaluation(){
        return Stream.of(
                dynamicTest("Supplier를 적용했을 때",() -> {
                    //given
                    long start = System.currentTimeMillis();
                    printMessageWithSupplier(() -> getMessage(), true);
                    printMessageWithSupplier(() -> getMessage(), false);
                    printMessageWithSupplier(() -> getMessage(), false);

                    //when
                    long result = (System.currentTimeMillis() - start) / 1000;

                    //then
                    assertThat(result).isEqualTo(3L);
                }),
                dynamicTest("Supplier를 적용 안했을 때",() -> {
                    //given
                    long start = System.currentTimeMillis();
                    printMessage(getMessage(), true);
                    printMessage(getMessage(), false);
                    printMessage(getMessage(), false);

                    //when
                    long result = (System.currentTimeMillis() - start) / 1000;

                    //then
                    assertThat(result).isEqualTo(9L);
                })
        );
    }

    private String getMessage(){
        try {
            TimeUnit.SECONDS.sleep(3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "HelloWorld";
    }

    private void printMessageWithSupplier(CustomSupplier<String> supplier, boolean isPrint){
        if(isPrint){
            System.out.println(supplier.get());
        } else {
            System.out.println("출력 거부");
        }
    }

    private void printMessage(String message, boolean isPrint){
        if(isPrint){
            System.out.println(message);
        } else {
            System.out.println("출력 거부");
        }
    }
}