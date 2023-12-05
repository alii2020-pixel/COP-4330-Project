// package frontend.MainScreenCustomer;

// import javax.swing.JComponent;

// public class MainScreenCustomerView extends JComponent {

// }

package frontend.MainScreenCustomer;

import javax.swing.*;

import frontend.Product.ProductController;
import frontend.Product.ProductModel;

import java.awt.*;
import java.util.List;

public class MainScreenCustomerView extends JComponent {

    private JList<String> productList;

    private ProductController controller;

    public MainScreenCustomerView() {
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        productList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(productList);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    public void setController(ProductController controller) {
        this.controller = controller;
    }

    public void updateProductList(List<String> products) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String product : products) {
            listModel.addElement(product);
        }
        productList.setModel(listModel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainScreenCustomerView view = new MainScreenCustomerView();
                ProductModel model = new ProductModel();
                ProductController controller = new ProductController(view, model);
                view.setController(controller);

                // For testing, add the view to a JFrame
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 300);
                frame.setLocationRelativeTo(null);
                frame.add(view);
                frame.setVisible(true);
            }
        });
    }
}
