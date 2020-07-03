package me.youngsil.optional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class Optional01 {

    public static void main(String[] args) {
        List<OnlineClass> springClass = new ArrayList<OnlineClass>();

        springClass.add(new OnlineClass(1, "spring 1", true));
        springClass.add(new OnlineClass(2, "spring 2", true));
        springClass.add(new OnlineClass(3, "spring 3", false));
        springClass.add(new OnlineClass(4, "spring 4", false));
        springClass.add(new OnlineClass(5, "spring 5", false));

        OnlineClass spring_boot = new OnlineClass(5, "spring 5", false);
        Optional progress = spring_boot.getProgress();

        //null 인지 판별
        System.out.println(progress.isPresent());

        //비어있는지 판별
        System.out.println(progress.isEmpty());

        //프리미티브 타입 사용가능하지만 오토박싱이 이루어짐
        // 성능이 안좋아진다. 아래것을 사용하자.
        Optional.of(10);
        OptionalInt.of(10);

        Optional<OnlineClass> spring = springClass.stream().
                filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        System.out.println("=========================================");
        //만약 있을때 사용
        spring.ifPresent(oc -> System.out.println(oc.getTitle()));

        //있으면 가져오고 없으면 만든다.
        //값이 있어도 생성은 한다???
        spring.orElse(new OnlineClass(2, "title", false));
        spring.orElse(new OnlineClass());

        //동적 작업에는 이것이 어울린다고 생각한다.
        spring.orElseGet(OnlineClass::new);

        //spring.orElseThrow(IllegalStateException::new);

        spring.filter(oc -> oc.getId() < 2).orElseThrow();
        Optional<Optional<Progress>> progress1 = spring.map(OnlineClass::getProgress);
        Optional<Progress> progress2 = spring.flatMap(OnlineClass::getProgress);
    }

}
