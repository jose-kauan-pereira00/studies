public class AssertsComparacaoBusca {

    private static final ComparacaoBusca comp = new ComparacaoBusca();
    private static final int[] v = new int[] {1, 4, 5, 6, 7, 8, 23, 45, 67, 89};
    private static final int MENOR_QUE_MINIMO = -9000;
    private static final int MAIOR_QUE_MAXIMO = 90000;

    public static void main(String[] args) {
        ensureAssertionsEnabled();
        testLimitesIterativa();
        testLimitesIterativaNaoEncontrou();
        testLimitesRecursiva();
        testLimitesRecursivaNaoEncontrou();
        System.out.println("Asserts de ComparacaoBusca executados.");
    }

    private static void ensureAssertionsEnabled() {
        boolean assertionsEnabled = false;
        assert assertionsEnabled = true;
        if (!assertionsEnabled) {
            throw new IllegalStateException("Execute com -ea para habilitar assertions.");
        }
    }

    private static void testLimitesIterativa() {
        assert comp.buscaBinariaIterativa(v, 1) == 0 : "Iterativa deve encontrar 1 no índice 0";
        assert comp.buscaBinariaIterativa(v, 89) == v.length - 1 : "Iterativa deve encontrar 89 no último índice";
    }

    private static void testLimitesIterativaNaoEncontrou() {
        assert comp.buscaBinariaIterativa(v, MENOR_QUE_MINIMO) == -1 : "Iterativa deve retornar -1 para valor menor que o mínimo";
        assert comp.buscaBinariaIterativa(v, MAIOR_QUE_MAXIMO) == -1 : "Iterativa deve retornar -1 para valor maior que o máximo";
    }

    private static void testLimitesRecursiva() {
        assert comp.buscaBinariaRecursiva(v, 0, v.length - 1, 1) == 0 : "Recursiva deve encontrar 1 no índice 0";
        assert comp.buscaBinariaRecursiva(v, 0, v.length - 1, 89) == v.length - 1 : "Recursiva deve encontrar 89 no último índice";
    }

    private static void testLimitesRecursivaNaoEncontrou() {
        assert comp.buscaBinariaRecursiva(v, 0, v.length - 1, MENOR_QUE_MINIMO) == -1 : "Recursiva deve retornar -1 para valor menor que o mínimo";
        assert comp.buscaBinariaRecursiva(v, 0, v.length - 1, MAIOR_QUE_MAXIMO) == -1 : "Recursiva deve retornar -1 para valor maior que o máximo";
    }
}
