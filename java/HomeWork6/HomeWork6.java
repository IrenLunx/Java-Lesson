// 1. Описать класс для работы с бинарным деревом  
// 1.1 Реализовать три варианта обхода - ru.wikipedia.org/wiki/Обход_дерева#Прямой_обход_(NLR)
// 1.2 Сделать скобочную запись бинарного дерева

// *2. Реализовать структуру данных "Очередь" на основе массива
// 2.1 Нужно сделать операцию "Добавить в очередь"
// 2.2 Нужно сделать операцию "Извлечь из очереди"

package HomeWork6;

public class HomeWork6 {
    public static void main(String[] args) {
        Node root = new Node("5");
        Node l1 = new Node("3");
        Node l11 = new Node("1");
        Node r12 = new Node("2");
        Node r2 = new Node("7");
        Node l21 = new Node("6");
        Node r21 = new Node("11");
        Node l221 = new Node("10");

        r2.left = l21;
        r2.right = r21;

        l1.left = l11;
        l1.right = r12;

        root.right = r2;
        root.left = l1;
        r21.left = l221;

        Node.Straight(root);
        System.out.println("");
        Node.Centered(root);
        System.out.println("");
        Node.Reverse(root);
    }
}

class Node {
    String value;
    Node left;
    Node right;

    public Node(String n) {
        value = n;
    }

    static void Straight(Node n) {
        if (n != null) {
            System.out.printf(" " + n.value);
            Straight(n.left);
            Straight(n.right);
        }
    }

    static void Reverse(Node n) {
        if (n != null) {    
            Reverse(n.left);
            Reverse(n.right);
            System.out.printf(" " + n.value);
        }
    }

    static void Centered(Node n) {
        if (n != null) {
            Centered(n.left);
            System.out.printf(" " + n.value);
            Centered(n.right);
        }
    }
}