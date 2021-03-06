//: typeinfo/pets/ForNameCreator.java
package typeinfo.pets;
import java.util.*;

public class ForNameCreator extends PetCreator {
  private static List<Class<? extends Pet>> types =
          new ArrayList<>();
  // Types that you want to be randomly created:
  private static String[] typeNames = {
    "typeinfo.pets.Mutt",
    "typeinfo.pets.Pug",
    "typeinfo.pets.EgyptianMau",
    "typeinfo.pets.Manx",
    "typeinfo.pets.Cymric",
    "typeinfo.pets.Rat",
    "typeinfo.pets.Mouse",
    "typeinfo.pets.Hamster"
  };	
  @SuppressWarnings("unchecked")
  // загрузчик списка классов
  private static void loader() {
    try {   //при загрузке класс приводится к типу заданному типизациии контейнера
      for(String name : typeNames)
        types.add(
          (Class<? extends Pet>)Class.forName(name));
    } catch(ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  // статический блок ОДНОКРТАНО загружающий список при инициализации данного класса
  static { loader(); }
  public List<Class<? extends Pet>> types() {return types;}
} ///:~
