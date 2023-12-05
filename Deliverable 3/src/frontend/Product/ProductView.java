package frontend.Product;

//  import javax.swing.JComponent;

//  public class ProductView extends JComponent {

// }

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ProductView extends JFrame {

    private JList<String> product;

    private ProductController controller;

    public ProductView() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        product = new JList<>();
        JScrollPane scrollPane = new JScrollPane(product);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);
    }

    public void setController(ProductController controller) {
        this.controller = controller;
    }

    public void updateProduct(List<String> products) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String product : products) {
            listModel.addElement(product);
        }
        this.product.setModel(listModel);
    }
}
