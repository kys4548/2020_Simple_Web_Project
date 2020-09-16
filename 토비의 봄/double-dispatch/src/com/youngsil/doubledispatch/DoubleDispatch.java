package com.youngsil.doubledispatch;

import java.util.Arrays;
import java.util.List;

/**
 * static dispatch : 컴파일 시점에 실행할 메서드를 결정.
 * dynamic dispatch : 런타임 시점에 들어오는 object를 보고 실행할 메서드를 결정해준다.
 *                     (파라미터는 dynamic dispatch의 조건이 되지 앟는다.)
 *
 *
 *  종류에 따라 각각 다른 비지니스 로직을 적용하고 싶을 때
 * 1. if에 instanceOf를 사용해 체크하여 각각 비지니스 로직 적용  - 이것보단 아래방법 사용하자.
 * 2. double dispatch 사용 (Visitor pattern)
 */
public class DoubleDispatch {
    public static void main(String[] args) {
        List<Post> postList = Arrays.asList(new Text(), new Picture());
        List<SNS> snsList = Arrays.asList(new FaceBook(), new Twitter());

        snsList.forEach(s -> postList.forEach(p -> p.postOn(s)));
    }

    interface Post {
        void postOn(SNS s);
    }

    static class Text implements Post {
        public void postOn(SNS s) {
            s.post(this);
        }
    }

    static class Picture implements Post {
        public void postOn(SNS s) {
            s.post(this);
        }
    }

    interface SNS {
        void post(Text text);
        void post(Picture picture);
    }


    static class FaceBook implements SNS {
        public void post(Text text) {
            System.out.println(this.getClass().getSimpleName() + " "  + text.getClass().getSimpleName());
        }

        public void post(Picture picture) {
            System.out.println(this.getClass().getSimpleName() + " "  + picture.getClass().getSimpleName());
        }
    }

    static class Twitter implements SNS {
        public void post(Text text) {
            System.out.println(this.getClass().getSimpleName() + " "  + text.getClass().getSimpleName());
        }

        public void post(Picture picture) {
            System.out.println(this.getClass().getSimpleName() + " "  + picture.getClass().getSimpleName());
        }
    }
}
