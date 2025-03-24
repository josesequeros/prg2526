//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Triangulo[] Triangulo;

    public static void main(Triangulo[] area) {
            int i, j;
            Triangulo aux;
            for (i = 1; i < area.length; i++) {
                aux = area[i];
                for (j = i - 1; j >= 0 && area().compareTo(Triangulo[j].area()) < 0; j--) {
                    area[j + 1] = area[j];
                }
                area[j + 1] = aux;

            }
        }
    }
