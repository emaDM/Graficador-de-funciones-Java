package graficador;

/*
Le puse Are por "Analisis recursivo de ecuaciones"
 */
/**
 * @author ema
 */
public class Are {

    public double f(double valor, String segmento, int salto, double parentesis) {   // cambio del algoritmo,se agrego "parentesis"

        int i = 0, b = 0, c = 0, z = 0;
        double x = 0;
        String[] temp;
        String seg1, seg2, seg3;

        while ((i < segmento.length()) && (b == 0) && (salto == 0)) {

            if (segmento.charAt(i) == '(') {
                temp = segmento.split("\\(", 2);
                seg1 = temp[0];

                seg2 = temp[1];
                b = 1;
                c = 1;
                z = 0;
                while ((z < seg2.length()) && (c != 0)) {

                    if (seg2.charAt(z) == '(') {
                        c++;
                    } else if (seg2.charAt(z) == ')') {
                        c--;
                        if (c == 0) {
                            seg3 = seg2.substring(z + 1, seg2.length());
                            seg2 = seg2.substring(0, z);
                            parentesis = f(valor, seg2, salto, parentesis);
                            seg1 = seg1 + 'P' + seg3;
                            x = f(valor, seg1, salto, parentesis);
                        }
                    }
                    z++;
                }
            }
            i++;
        }

        if (b == 1) {
            return x;
        } else if (salto == 0) {
            salto = 1;
        }

        i = 0;

        while ((i < segmento.length()) && (b == 0) && (salto == 1)) {

            if (segmento.charAt(i) == '+') {
                temp = segmento.split("\\+", 2);
                x = f(valor, temp[0], salto, parentesis);
                x = x + f(valor, temp[1], salto, parentesis);
                b = 1;
            }
            i++;
        }

        if (b == 1) {
            return x;
        } else if (salto == 1) {
            salto = 2;
        }

        i = 0;
        while ((i < segmento.length()) && (b == 0) && (salto == 2)) {

            if (segmento.charAt(i) == '-') {
                temp = segmento.split("\\-", 2);
                System.out.println("encontro -: " + temp[1]);
                if (temp[0] == null) {                                  //cambio1
                    x = f(valor, temp[0], salto, parentesis);
                    x = x - f(valor, temp[1], salto, parentesis);
                } else {
                    x = 0 - f(valor, temp[1], salto, parentesis);
                }

                b = 1;
            }
            i++;
        }

        if (b == 1) {
            return x;
        } else if (salto == 2) {
            salto = 3;
        }

        i = 0;
        while ((i < segmento.length()) && (b == 0) && (salto == 3)) {

            if (segmento.charAt(i) == '*') {
                temp = segmento.split("\\*", 2);
                x = f(valor, temp[0], salto, parentesis);
                x = x * f(valor, temp[1], salto, parentesis);
                b = 1;
            }
            i++;
        }

        if (b == 1) {
            return x;
        } else if (salto == 3) {
            salto = 4;
        }

        i = 0;
        while ((i < segmento.length()) && (b == 0) && (salto == 4)) {

            if (segmento.charAt(i) == '/') {
                temp = segmento.split("/", 2);
                x = f(valor, temp[0], salto, parentesis);
                x = x / f(valor, temp[1], salto, parentesis);
                b = 1;
            }
            i++;
        }

        if (b == 1) {
            return x;
        } else if (salto == 4) {
            salto = 5;
        }

        i = 0;
        while ((i < segmento.length()) && (b == 0) && (salto == 5)) {

            if (segmento.charAt(i) == '^') {
                temp = segmento.split("\\^");
                x = f(valor, temp[0], salto, parentesis);
                x = Math.pow(x, f(valor, temp[1], salto, parentesis));
                b = 1;
            }
            i++;
        }

        if (b == 1) {
            return x;
        } else if (salto == 5) {
            salto = 6;
        }
/////////////////////////////////////////////////////////////////////////////////////////////
        i = 0;
        while ((i < segmento.length()) && (b == 0) && (salto == 6)) {

            if (segmento.charAt(i) == 's') {
                temp = segmento.split("s");
                x = Math.sin(f(valor, temp[1], salto, parentesis));

                b = 1;
            }
            i++;
        }

        if (b == 1) {
            return x;
        } else if (salto == 6) {
            salto = 7;
        }

        i = 0;
        while ((i < segmento.length()) && (b == 0) && (salto == 7)) {

            if (segmento.charAt(i) == 'c') {
                temp = segmento.split("c");
                x = Math.cos(f(valor, temp[1], salto, parentesis));

                b = 1;
            }
            i++;
        }

        if (b == 1) {
            return x;
        } else if (salto == 7) {
            salto = 8;
        }

        i = 0;
        while ((i < segmento.length()) && (b == 0) && (salto == 8)) {

            if (segmento.charAt(i) == 't') {
                temp = segmento.split("t");
                x = Math.tan(f(valor, temp[1], salto, parentesis));

                b = 1;
            }
            i++;
        }

        if (b == 1) {
            return x;
        } else if (salto == 8) {
            salto = 9;
        }

/////////////////////////////////////////////////////////////////////////////////////////////
        i = 0;
        while ((i < segmento.length()) && (b == 0) && (salto == 9)) {   //nuevo cambio , ciclo para reconocer parentesis

            if (segmento.charAt(i) == 'P') {
                temp = segmento.split("P");
                x = parentesis;

                b = 1;
            }
            i++;
        }

        if (b == 1) {
            return x;
        } else if (salto == 9) {
            salto = 10;
        }

        i = 0;
        while ((i < segmento.length()) && (b == 0)) {

            if (segmento.charAt(i) == 'x') {
                if (segmento.length() > 1) {
                    temp = segmento.split("x");
                    x = valor * Double.parseDouble(temp[0]);
                } else {
                    x = valor;
                }

                b = 1;
            }
            i++;
        }

        if (b == 0) {
            x = Double.parseDouble(segmento);
        }

        return x;
    }

}
