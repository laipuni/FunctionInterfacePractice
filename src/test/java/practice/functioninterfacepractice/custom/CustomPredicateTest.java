package practice.functioninterfacepractice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.*;

class CustomPredicateTest {

    @DisplayName("Predicate는 인자를 받아서 boolean값을 반환한다.")
    @Test
    void CustomPredicate(){
        //given
        int validAge = 30;
        Member member = new Member("laipuni",25);
        CustomPredicate<Member> customPredicate = m -> m.getAge() < 30;

        //when//then
        assertThat(customPredicate.test(member)).isTrue();
    }

    @DisplayName("람다식의 filter에서 Predicate를 이용해서 나이가 30이하인 유저들을 필터링할 수 있다.")
    @Test
    void CustomPredicateWithLambdaFilter(){
        //given
        List<Member> members = List.of(
                new Member("jinho",25),
                new Member("tomodachi",45),
                new Member("jason",32),
                new Member("jack",15)
        );

        CustomPredicate<Member> customPredicate = m->m.getAge() <= 30;

        //when
        List<Member> filteredMember = members.stream()
                .filter(customPredicate::test)
                .toList();

        //then
        assertThat(filteredMember).hasSize(2)
                .extracting("name","age")
                .containsExactlyInAnyOrder(
                        tuple("jinho",25),
                        tuple("jack",15)
                );
    }
}