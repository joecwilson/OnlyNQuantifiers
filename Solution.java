public class Solution {
    static final char[] mappings = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static void main(String[] args) {
        System.out.println("\\documentclass{article}");
        System.out.println("\\begin{document}");
        System.out.println("\\author{Joseph Wilson}");
        System.out.println("\\title{Only N Quantifiers}");
        System.out.println("\\setlength{\\parindent}{0pt}");
        System.out.println("\\maketitle");

        for (int n = 2; n < mappings.length; n++) {
            if (n != 2) {
                System.out.println("\\pagebreak");
                System.out.println("\\medbreak");
            }

            System.out.println("Exactly " + n + " quantifier (hopefully)\\\\");
            StringBuilder builder = new StringBuilder();
            // Inital quantifiers
            // exists x| in D : P(x) and
            builder.append('$');
            for (int i = 0; i < n; i++) {
                builder.append("(\\exists ");
                builder.append(mappings[i]);
                builder.append("| ");
                builder.append(mappings[i]);
                builder.append("\\in D : P(");
                builder.append(mappings[i]);
                builder.append(") \\wedge");
            }

            // Make sure all are not equal
            builder.append("( ");
            addNotEqual(builder, n);
            builder.append(") \\wedge (\\forall Z| Z \\in D: P(Z) \\rightarrow (");
            // Z is none of the above
            for (int i = 0; i < n - 1; i++) {
                builder.append("(Z = ");
                builder.append(mappings[i]);
                builder.append(") \\vee ");
            }
            builder.append("(Z = ");
            builder.append(mappings[n - 1]);
            for (int i = 0; i < n; i++) {
                builder.append(')');
            }

            builder.append(")))$");
            builder.append("\n");
            builder.append("\\medbreak");
            System.out.println(builder);

        }
        System.out.println("\\end{document}");
    }

    public static void addNotEqual(StringBuilder builder, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                builder.append("( ");
                builder.append(mappings[i]);
                builder.append(" \\neq ");
                builder.append(mappings[j]);
                builder.append(") \\wedge");
            }
        }
        builder.delete(builder.length() - 6, builder.length());
    }
}
