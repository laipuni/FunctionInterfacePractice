package practice.functioninterfacepractice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomFunctionTest {

    @DisplayName("Function은 T인자를 받아서 R을 반환한다.")
    @Test
    void customFunction(){
        //given
        int testAge = 25;
        Member member = new Member("jinho",testAge);
        CustomFunction<Member,Integer> customFunction = m -> m.getAge();

        //when
        Integer resultAge = customFunction.apply(member);

        //then
        assertThat(resultAge).isEqualTo(testAge);
    }

}