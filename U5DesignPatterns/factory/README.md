# Pizza factory pattern examples

Each example is independent, with Java sources under its own `src` directory.
Package names use a distinct prefix so the examples can also compile together.

| Example folder | Package prefix | Packages and responsibilities |
| --- | --- | --- |
| `pizzaStoreSimpleFactory` | `simplefactory` | `pizza`: pizza base class and products; `factory`: simple factory; `store`: ordering; `demo`: main program |
| `pizzaStoreFactoryMethod` | `factorymethod` | `pizza`: pizza base class and regional products; `store`: abstract creator, regional stores, and the dependent-store comparison; `demo`: main program |
| `pizzaStoreAbstractFactory` | `abstractfactory` | `pizza`: pizza base class and products; `ingredients`: ingredient interfaces and implementations; `factory`: ingredient factory interface and regional factories; `store`: ordering and regional stores; `demo`: main program |

For example, `abstractfactory.factory.PizzaIngredientFactory` lives in
`pizzaStoreAbstractFactory/src/abstractfactory/factory/PizzaIngredientFactory.java`.
Use each example's `src` directory as its source root in an IDE.

## Compile and run

From this `factory` folder, with a JDK installed:

```sh
mkdir -p out
find pizzaStoreSimpleFactory/src pizzaStoreFactoryMethod/src pizzaStoreAbstractFactory/src -name '*.java' > out/sources.txt
javac -d out @out/sources.txt

java -cp out simplefactory.demo.PizzaTestDrive
java -cp out factorymethod.demo.PizzaTestDrive
java -cp out abstractfactory.demo.PizzaTestDrive
```

To compile just one example, include only its `src` directory in the `find`
command. Run demos using their fully qualified names as shown above. Older
`.class` files directly inside the example folders are from the original
default-package layout; these commands use the newly compiled classes in `out`.

Pizza lifecycle methods called by stores are now `public` because stores and
pizzas live in separate packages. In the abstract factory example, `setName`
and `getName` are also public. The factory pattern behavior is unchanged.
