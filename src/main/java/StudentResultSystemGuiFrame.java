import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentResultSystemGuiFrame extends JFrame {
    private JPanel rootPanel;
    private JPanel studentPanel;
    private JPanel gradesPanel;
    private JPanel tablePanel;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField courseField;
    private JTextField idField;
    private JTextField mathField;
    private JTextField russianField;
    private JTextField englishField;
    private JTextField chemistryField;
    private JTextField physicsField;
    private JTextField historyField;
    private JTextField socialStudiesField;
    private JTextField geographyField;
    private JTextArea resultsTextArea;
    private JPanel settingsPanel;
    private JTable resultTable;
    private JButton runkingButton;
    private JButton transcriptButton;
    private JButton deleteButton;
    private JButton resetButton;
    private JButton exitButton;
    private JLabel avarageResultLabel;
    private String name, surname, coursecode, fullname;
    private int id, math, russian, english, chemistry, physics, history,
            socialStudies, geography;
    private double avarage;
    private String[] columnsName;

    StudentResultSystemGuiFrame(String title) {
        super(title);
        setContentPane(rootPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        idField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                id = Integer.parseInt(idField.getText());
            }
        });
        nameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                name = nameField.getText();
            }
        });
        surnameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                surname = surnameField.getText();
            }
        });
        courseField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                coursecode = courseField.getText();
            }
        });
        mathField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                math = Integer.parseInt(mathField.getText());
            }
        });
        russianField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                russian = Integer.parseInt(russianField.getText());
            }
        });
        englishField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                english = Integer.parseInt(englishField.getText());
            }
        });
        chemistryField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                chemistry = Integer.parseInt(chemistryField.getText());
            }
        });
        physicsField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                physics = Integer.parseInt(physicsField.getText());
            }
        });
        historyField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                history = Integer.parseInt(historyField.getText());
            }
        });
        socialStudiesField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                socialStudies = Integer.parseInt(socialStudiesField.getText());
            }
        });
        geographyField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                geography = Integer.parseInt(geographyField.getText());
            }
        });

        columnsName = new String[]{"ID Студента", "Имя", "Класс", "Математика", "Русский язык",
                "Английский язык", "Химия", "Физика", "История", "Обществознание", "География", "Средний балл"};
        DefaultTableModel tableModel = new DefaultTableModel();
        resultTable = new JTable(tableModel);
        for (int i = 0; i < columnsName.length; i++) {
            tableModel.addColumn(columnsName[i]);
        }

        runkingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fullname = name + " " + surname;
                avarage = (math + russian + english + chemistry + physics + history + socialStudies + geography) / 8;
                avarageResultLabel.setText(String.valueOf(avarage));
                String[] values = new String[]{String.valueOf(id), fullname, coursecode, String.valueOf(math),
                        String.valueOf(russian), String.valueOf(english), String.valueOf(chemistry),
                        String.valueOf(physics), String.valueOf(history), String.valueOf(socialStudies),
                        String.valueOf(geography), String.valueOf(avarage)};
                tableModel.insertRow(0, values);

            }
        });
        transcriptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                resultsTextArea.setText("Система оценивания студентов\n" +
                        "============================\n" +
                        "Студент: " + fullname + ", " + coursecode + " класса\n" +
                        "Математика: " + math + "\n" +
                        "Русский язык: " + russian + "\n" +
                        "Английский язык: " + english + "\n" +
                        "Химия: " + chemistry + "\n" +
                        "Физика: " + physics + "\n" +
                        "История: " + history + "\n" +
                        "Обществознание: " + socialStudies + "\n" +
                        "География: " + geography + "\n" +
                        "============================\n" +
                        "Средний балл: " + avarage);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                class askedWindow extends Frame {
                    askedWindow() {
                        setLayout(new FlowLayout());
                        setSize(350, 200);
                        JLabel askedLabel = new JLabel("Введите ID студента, которого желаете удалить");
                        add(askedLabel);
                        JTextField askedWindowField = new JTextField();
                        add(askedWindowField);
                        JButton askedWindowButtonYes = new JButton("Да");
                        askedWindowButtonYes.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {
                                tableModel.removeRow(0);
                                dispose();
                            }
                        });
                        add(askedWindowButtonYes);
                        JButton askedWindowButtonNo = new JButton("Нет");
                        askedWindowButtonNo.addActionListener(ae -> dispose());
                        add(askedWindowButtonNo);
                        setVisible(true);
                    }
                }
            }
        });
        setVisible(true);
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentResultSystemGuiFrame("Система оценки студентов");
            }
        });
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rootPanel = new JPanel();
        rootPanel.setLayout(new FormLayout("fill:d:grow,left:4dlu:noGrow,fill:d:grow", "center:d:noGrow,top:5dlu:noGrow,center:max(d;4px):noGrow,top:5dlu:noGrow,center:max(d;4px):noGrow"));
        rootPanel.setMaximumSize(new Dimension(21474, 21474));
        rootPanel.setMinimumSize(new Dimension(100, 100));
        rootPanel.setPreferredSize(new Dimension(1920, 800));
        rootPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        studentPanel = new JPanel();
        studentPanel.setLayout(new GridLayoutManager(16, 4, new Insets(0, 0, 0, 0), 3, 2, true, false));
        studentPanel.setMaximumSize(new Dimension(214748, 214748));
        studentPanel.setMinimumSize(new Dimension(100, 100));
        studentPanel.setName("Classes");
        studentPanel.setPreferredSize(new Dimension(500, 500));
        CellConstraints cc = new CellConstraints();
        rootPanel.add(studentPanel, cc.xy(1, 1));
        studentPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "ОЦЕНКИ СТУДЕНТА", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, null, null));
        final Spacer spacer1 = new Spacer();
        studentPanel.add(spacer1, new GridConstraints(14, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        studentPanel.add(spacer2, new GridConstraints(12, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        studentPanel.add(spacer3, new GridConstraints(10, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        studentPanel.add(spacer4, new GridConstraints(8, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        studentPanel.add(spacer5, new GridConstraints(6, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer6 = new Spacer();
        studentPanel.add(spacer6, new GridConstraints(4, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer7 = new Spacer();
        studentPanel.add(spacer7, new GridConstraints(2, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("ID Студента");
        studentPanel.add(label1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 19), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Имя");
        studentPanel.add(label2, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 19), null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Фамилия");
        studentPanel.add(label3, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 19), null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Номер класса");
        studentPanel.add(label4, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 19), null, 0, false));
        nameField = new JTextField();
        nameField.setText("");
        studentPanel.add(nameField, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        surnameField = new JTextField();
        studentPanel.add(surnameField, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        courseField = new JTextField();
        studentPanel.add(courseField, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        idField = new JTextField();
        studentPanel.add(idField, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        final Spacer spacer8 = new Spacer();
        studentPanel.add(spacer8, new GridConstraints(0, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("История");
        studentPanel.add(label5, new GridConstraints(11, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Обществознание");
        studentPanel.add(label6, new GridConstraints(13, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("География");
        studentPanel.add(label7, new GridConstraints(15, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Математика");
        studentPanel.add(label8, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("Русский язык");
        studentPanel.add(label9, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("Английский язык");
        studentPanel.add(label10, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label11 = new JLabel();
        label11.setText("Химия");
        studentPanel.add(label11, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label12 = new JLabel();
        label12.setText("Физика");
        studentPanel.add(label12, new GridConstraints(9, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label13 = new JLabel();
        label13.setText("Средняя оценка:");
        studentPanel.add(label13, new GridConstraints(9, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 19), null, 0, false));
        mathField = new JTextField();
        studentPanel.add(mathField, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        russianField = new JTextField();
        studentPanel.add(russianField, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        englishField = new JTextField();
        studentPanel.add(englishField, new GridConstraints(5, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        chemistryField = new JTextField();
        studentPanel.add(chemistryField, new GridConstraints(7, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        physicsField = new JTextField();
        studentPanel.add(physicsField, new GridConstraints(9, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        historyField = new JTextField();
        studentPanel.add(historyField, new GridConstraints(11, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        socialStudiesField = new JTextField();
        studentPanel.add(socialStudiesField, new GridConstraints(13, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        geographyField = new JTextField();
        studentPanel.add(geographyField, new GridConstraints(15, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        avarageResultLabel = new JLabel();
        avarageResultLabel.setText("");
        studentPanel.add(avarageResultLabel, new GridConstraints(9, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gradesPanel = new JPanel();
        gradesPanel.setLayout(new CardLayout(0, 0));
        gradesPanel.setMinimumSize(new Dimension(100, 100));
        gradesPanel.setPreferredSize(new Dimension(500, 500));
        rootPanel.add(gradesPanel, cc.xy(3, 1));
        gradesPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        resultsTextArea = new JTextArea();
        gradesPanel.add(resultsTextArea, "Card1");
        tablePanel = new JPanel();
        tablePanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tablePanel.setPreferredSize(new Dimension(1380, 300));
        rootPanel.add(tablePanel, cc.xywh(1, 3, 1, 3));
        tablePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JScrollPane scrollPane1 = new JScrollPane();
        tablePanel.add(scrollPane1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        scrollPane1.setBorder(BorderFactory.createTitledBorder(null, "Таблица с результатами", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        resultTable = new JTable();
        resultTable.setAutoCreateRowSorter(false);
        resultTable.setEditingColumn(13);
        resultTable.setEditingRow(1);
        resultTable.setEnabled(false);
        resultTable.setName("Таблица оценок");
        scrollPane1.setViewportView(resultTable);
        settingsPanel = new JPanel();
        settingsPanel.setLayout(new GridBagLayout());
        rootPanel.add(settingsPanel, cc.xy(3, 5));
        transcriptButton = new JButton();
        transcriptButton.setText("Подробнее");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        settingsPanel.add(transcriptButton, gbc);
        final JPanel spacer9 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        settingsPanel.add(spacer9, gbc);
        final JPanel spacer10 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        settingsPanel.add(spacer10, gbc);
        deleteButton = new JButton();
        deleteButton.setText("Удалить");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        settingsPanel.add(deleteButton, gbc);
        runkingButton = new JButton();
        runkingButton.setAutoscrolls(true);
        runkingButton.setText("Подсчитать");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        settingsPanel.add(runkingButton, gbc);
        resetButton = new JButton();
        resetButton.setText("Обновить");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        settingsPanel.add(resetButton, gbc);
        exitButton = new JButton();
        exitButton.setText("Выход");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        settingsPanel.add(exitButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }

}
