// my test generator
package generics.coffee;

import net.mindview.util.Generator;

import java.util.Random;

public class TestGenerator implements Generator<Integer> {

    @Override
    public Integer next() {
        Random random = new Random(47);
        return random.nextInt();
    }
}
