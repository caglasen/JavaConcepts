import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Optional;

public class OptionalKeywordExamples {
    public static void Main(){
        Integer a = null;

        // If there is a chance that the variable can be null, then use ofNullable
        Optional<Integer> maybeInteger = Optional.ofNullable(a);

        // But if there is no a chance that the variable can be null, then just use ofNu
        Optional<String> gender = Optional.of("MALE");

        // Send the parameter inside Optional.of() or Optional.ofNullable()
        b(Optional.ofNullable(a));


        String name = "FOLKSDEV";
        printName(name);
        printName("caglasen");
    }


    // Wrap the parameter object with Optional keyword
    public static void b(Optional<Integer> param){
        // Write parameter if it is present, inside ifPresents() method
        param.ifPresent(System.out::println);
    }

    public static void printName(String name){
        // For instance since is a chance that name can be null, we use ofNullable
        Optional<String> nameOptional = Optional.ofNullable(name);

        //nameOptional.ifPresent(System.out::println);

        //Since we used mapping on an optional variable, we don't have to check whether the value is null or not
        //System.out.println(nameOptional.map(s -> s.toUpperCase()));

        //We can write the same of the upper expression with lambda method reference(::) expression
        System.out.println(
                 nameOptional
                .map(String::toUpperCase)   // Optional string
                .orElse("")           // if the string is null, return this
        );

        Optional<Optional<String>> nameOpt = Optional.of(nameOptional);

        System.out.println(
                 nameOpt
                .map(s-> s.map(String::toUpperCase))   // Optional string
                .orElse(Optional.of(""))           // if the string is null, return this
        );


        // FILTERING
        Optional<String> nameOptional2 = Optional.ofNullable(name);

        if(name != null){
            if(name.length() > 3 && name.charAt(0) == 'T'){
                System.out.println(name);
            }
        }

        System.out.println(
                nameOptional2
                        .filter(n -> n.length() > 3 & n.charAt(0) == 'T')
                        .orElse(""));

        Optional<String> nameOptional3 = Optional.ofNullable(name);

        if(nameOptional3.isPresent()){
            System.out.println(nameOptional3.get());
        }else{
            System.out.println("No name entered");
        }


        if(nameOptional3.isEmpty()){
            System.out.println("No name entered");
        }else{
            System.out.println(nameOptional3.get());
        }

        // nameOptional3 null değilse çalıştırılacak kod bloğu ifPresent içine yazılır
        nameOptional3.ifPresent( taner -> c(taner) );

        // JAVA 9+

        nameOptional3.ifPresentOrElse(n->c(n),
                ()-> System.out.println("isim girilmedi."));
    }

    public static String c(String a){
        System.out.println(a);
        return "hello" + a;
    }
}


