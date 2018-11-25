package Model;

public abstract class TextosModel {
    public static String getTexto1(String id){
        String texto = "";
        switch (id){
            case "merc":
                texto = "Pode ser visto da Terra a olho nu, contudo pouco antes do amanhecer e " +
                        "instantes após o anoitecer porque sua proximidade com o Sol dificulta a observação.";
                break;
            case "venus":
                texto = "Existem 4 planetas terrestres. Esse é um deles. Seu brilho peculiar é " +
                        "causado pela pesada atmosfera, que irradia o calor da luz do Sol na superfície. " +
                        "A pressão atmosférica ao nível do mar é 92 vezes maior que a da Terra.";
                break;
            case "terra":
                texto = "Este é o único planeta do sistema solar em que existe água " +
                        "em estado líquido, característica que junto ao oxigênio, torna possível " +
                        "a vida. Essa água corresponde cerca de 70% da superfície " +
                        "do planeta, local chamado de hidrosfera.";
                break;
            case "mart":
                texto = "Aqui orbita um planeta muito frio, árido e rochoso. " +
                        "A sua temperatura máxima é de aproximadamente 25°C, " +
                        "com uma média de -60°C, a qual pode chegar até cerca de -140°C durante à noite.";
                break;
            case "jup":
                texto = "A atmosfera do planeta é dividida em diversas faixas, " +
                        "em várias latitudes, resultando em turbulência e tempestades. " +
                        "Essas tempestades tem um diâmetro transversal duas vezes maior do que a Terra.";
                break;
            case "sat":
                texto = "Por ser um planeta gasoso, é composto principalmente por hidrogênio e hélio. " +
                        "Ou seja, não há superfície sólida. O centro dele é composto " +
                        "por um núcleo denso de rocha, gelo e água.";
                break;
            case "ura":
                texto = "Em 1977 foram descobertos cinco anéis, denominados Alpha, Beta, Gamma, " +
                        "Delta e Epsilon, considerando a ordem crescente de distância do planeta " +
                        "pelos pesquisadores do Airborne Observatory.";
                break;
            case "netu":
                texto = "Está distante 4,5 bilhões de quilômetros do Sol e demora 156 anos " +
                        "terrestres para completar sua órbita. Foi descoberto em 1846 e " +
                        "recebeu o nome do deus romano do mar.";
                break;
                default:
                    System.out.println("Opçao incorreta!");
        }
        return texto;
    }
}
