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

    public static String getTexto2(int pla){
        String texto = "";
        switch (pla){
            case 9:
                texto = "Em função de sua proximidade do Sol, este planeta apresenta temperaturas altíssimas. " +
                        "A temperatura média na superfície é de 126°C, podendo chegar na máxima de 425°C.";
                break;
            case 8:
                texto = "É o planeta mais próximo da Terra." +
                        " A rotação dele ocorre de leste para oeste, " +
                        "contrária a todos os planetas do Sistema Solar.";
                break;
            case 7:
                texto = "O Planeta é composto por camadas que partem desde a " +
                        "superfície terrestre até o núcleo, desse modo são denominadas " +
                        "litosfera, crosta, manto, astenosfera, núcleo externo e núcleo interno.";
                break;
            case 6:
                texto = "Possui duas pequenas luas de formato irregular: Fobos (medo) e Deimos (pânico). " +
                        "Seus nomes derivam da mitologia grega e representam os filhos de Ares e Afrodite.";
                break;
            case 5:
                texto = "Esse planeta foi observado a primeira vez por Galileu Galilei, em 1610, quando também foi possível a" +
                        " identificação de quatro de seus 63 satélites, Io, Europa, Ganimedes e Calisto. A primeira " +
                        "sonda a visita-lo foi a Pioneer 10 em 1973.";
                break;
            case 4:
                texto = "As observações realizadas indicam que os anéis do planeta são formados por" +
                        " pedaços de cometas, asteroides e luas despedaçadas. Os anéis mais conhecidos são denominados " +
                        "A, B e C, mas há sete no total, todos representam letras do alfabeto à medida em que foram descobertos.";
                break;
            case 3:
                texto = "O planeta possui 27 luas conhecidas que são nomeadas com personagens das obras de William" +
                        " Shakespeare ou Alexander Pope. As primeiras quatro luas, Titania, Oberon, Ariel e " +
                        "Umbriel foram descobertas entre 1787-1851.";
                break;
            case 2:
                texto = "A sua principal lua é Tritão. Desde que foi descoberto, a primeira volta ao Sol dele ocorreu em 2011. " +
                        "O planeta é invisível a olho nu por causa de sua extrema distância da Terra. " +
                        "O campo magnético é cerca de 27 vezes mais potente que o da Terra.";
                break;
            case 1:
                texto = "Durante 20 anos dos 248 de sua órbita ele fica mais próximo do sol do que " +
                        "netuno devido ao fato de sua órbita ser elíptica. Outro fato interessante é " +
                        "que a órbita de plutão passa pela de netuno em determinado período de seu trajeto, " +
                        "quando ambos percorrem a mesma órbita em torno do sol.";
                break;
            default:
                System.out.println("Opçao incorreta!");
        }
        return texto;
    }

    public static String getTexto3(int pla){
        String texto = "";
        switch (pla){
            case 9:
                texto = "Em função de sua proximidade do Sol, este planeta apresenta temperaturas altíssimas. " +
                        "A temperatura média na superfície é de 126°C, podendo chegar na máxima de 425°C.";
                break;
            case 8:
                texto = "É o planeta mais próximo da Terra." +
                        " A rotação dele ocorre de leste para oeste, " +
                        "contrária a todos os planetas do Sistema Solar.";
                break;
            case 7:
                texto = "O Planeta é composto por camadas que partem desde a " +
                        "superfície terrestre até o núcleo, desse modo são denominadas " +
                        "litosfera, crosta, manto, astenosfera, núcleo externo e núcleo interno.";
                break;
            case 6:
                texto = "Possui duas pequenas luas de formato irregular: Fobos (medo) e Deimos (pânico). " +
                        "Seus nomes derivam da mitologia grega e representam os filhos de Ares e Afrodite.";
                break;
            case 5:
                texto = "Esse planeta foi observado a primeira vez por Galileu Galilei, em 1610, quando também foi possível a" +
                        " identificação de quatro de seus 63 satélites, Io, Europa, Ganimedes e Calisto. A primeira " +
                        "sonda a visita-lo foi a Pioneer 10 em 1973.";
                break;
            case 4:
                texto = "As observações realizadas indicam que os anéis do planeta são formados por" +
                        " pedaços de cometas, asteroides e luas despedaçadas. Os anéis mais conhecidos são denominados " +
                        "A, B e C, mas há sete no total, todos representam letras do alfabeto à medida em que foram descobertos.";
                break;
            case 3:
                texto = "O planeta possui 27 luas conhecidas que são nomeadas com personagens das obras de William" +
                        " Shakespeare ou Alexander Pope. As primeiras quatro luas, Titania, Oberon, Ariel e " +
                        "Umbriel foram descobertas entre 1787-1851.";
                break;
            case 2:
                texto = "A sua principal lua é Tritão. Desde que foi descoberto, a primeira volta ao Sol dele ocorreu em 2011. " +
                        "O planeta é invisível a olho nu por causa de sua extrema distância da Terra. " +
                        "O campo magnético é cerca de 27 vezes mais potente que o da Terra.";
                break;
            case 1:
                texto = "Durante 20 anos dos 248 de sua órbita ele fica mais próximo do sol do que " +
                        "netuno devido ao fato de sua órbita ser elíptica. Outro fato interessante é " +
                        "que a órbita de plutão passa pela de netuno em determinado período de seu trajeto, " +
                        "quando ambos percorrem a mesma órbita em torno do sol.";
                break;
            default:
                System.out.println("Opçao incorreta!");
        }
        return texto;
    }
}
