package practice.functioninterfacepractice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomConsumerTest {

    @DisplayName("Consumer은 T인자를 받아서 T인자를 소모하고 반환 값이 없다.")
    @Test
    void customConsumer(){
        //given
        int ageBeforeEdit = 25;
        int ageAfterEdit = 50;

        Member member = new Member("jinho",ageBeforeEdit);
        CustomConsumer<Member> customConsumer = m -> m.setAge(ageAfterEdit);

        //when
        customConsumer.accept(member);

        //then
        assertThat(member.getAge()).isEqualTo(ageAfterEdit);

    }

}