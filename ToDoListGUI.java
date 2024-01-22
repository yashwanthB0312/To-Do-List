package ToDoList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListGUI extends JFrame {
    private DefaultListModel<String> todolistmodel;
    private JList<String> list;
    private JTextField org;
    ToDoListGUI() {
        setTitle("To-Do List");
        setSize(400, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        todolistmodel = new DefaultListModel<>();
        list = new JList<>(todolistmodel);
        org = new JTextField(20);
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Delete");
        JScrollPane scrollPane = new JScrollPane(list);
        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(org);
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        add(buttonPanel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remTask();
            }
        });
    }
    private void addTask() {
        String task = org.getText().trim();
        if (!task.isEmpty()) {
            todolistmodel.addElement(task);
            org.setText("");
            JOptionPane.showMessageDialog(this, "Task added successfully");
        }
    }
    private void remTask() {
        int selectedIndex = list.getSelectedIndex();
        if (selectedIndex != -1) {
            todolistmodel.remove(selectedIndex);
            JOptionPane.showMessageDialog(this, "Task removed successfully");
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToDoListGUI().setVisible(true);
            }
        });
    }
}