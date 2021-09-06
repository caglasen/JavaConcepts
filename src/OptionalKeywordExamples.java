import java.util.Optional;

public class OptionalKeywordExamples {
    public static void Main(){
        Integer a = null;

        // If there is a chance that the variable can be null, then use ofNullable
        Optional<Integer> maybeInteger = Optional.ofNullable(a);

        // But if there is no a chance that the variable can be null, then just use ofNu
        Optional<String> gender = Optional.of("MALE");

        // Send the parameter inside Optional.of() or Optional.ofNullable()
        b(Optional.of(a));
    }


    // Wrap the parameter object with Optional keyword
    public static void b(Optional<Integer> param){
        // Write parameter if it is present, inside ifPresents() method
        param.ifPresent(System.out::println);
    }

    public static void printName(String name){
        // For instance since is a chance that name can be null, we use ofNullable
        Optional<String> nameOptional = Optional.ofNullable(name);
        nameOptional.ifPresent(System.out::println);
    }
}


