import java.util.Arrays;
import java.util.HashSet;
// 집합자료형이 있습니다
// 순서가 없고 중복값이 없다고 말씀드렸습니다 (인덱스 불가능)
// 교집합, 합집합 같은 집합특성을 살린 분류 가능
public class set {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<> (Arrays.asList("h", "e", "l", "l", "o"));
        System.out.print(set);
        // 집합 2개를 정의합니다
        HashSet<Integer> s1 = new HashSet<> (Arrays.asList(1,2,3,4,5,6));
        HashSet<Integer> s2 = new HashSet<> (Arrays.asList(4,5,6,7,8,9));
        // 교집합 변수 intersection를 선언하고 s1과 s2를 retainAll로 교집합 수행
        HashSet<Integer> intersection = new HashSet<> (s1);
        intersection.retainAll(s2);
        System.out.print(intersection);
        // 합집합 변수 union를 선언하고 s1과 s2를 allAll로 합집합 수행
        HashSet<Integer> union = new HashSet<> (s1);
        union.addAll(s2);
        System.out.print(union);
        // 차집합 변수 substract를 선언하고 s1과 s2를 removeAll로 합집합 수행
        HashSet<Integer> substract = new HashSet<> (s1);
        substract.removeAll(s2);
        System.out.print(substract);
    }
}
