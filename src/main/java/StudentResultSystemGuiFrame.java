import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;

import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Locale;


public class StudentResultSystemGuiFrame extends JFrame {
    private JPanel rootPanel;
    private JPanel studentPanel;
    private JPanel gradesPanel;
    private JTextField nameField;
    private JTextField surnameField;
    private JComboBox courseField;
    private JTextField idField;
    private JComboBox mathField;
    private JComboBox russianField;
    private JComboBox englishField;
    private JComboBox chemistryField;
    private JComboBox physicsField;
    private JComboBox historyField;
    private JComboBox socialStudiesField;
    private JComboBox geographyField;
    private JTextArea resultsTextArea;
    private JPanel settingsPanel;
    private JTable resultTable;
    private JButton runkingButton;
    private JButton transcriptButton;
    private JButton deleteButton;
    private JButton resetButton;
    private JButton exitButton;
    private JLabel avarageResultLabel;
    private JTable table1;
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JScrollPane scrollPane1;
    private String name, surname, coursecode, fullname;
    private int id;
    private double math, russian, english, chemistry, physics, history,
            socialStudies, geography;
    private double avarage;
    private LinkedList<String> columnsName;
    DefaultTableModel dftTableModel;

    StudentResultSystemGuiFrame(String title) {
        super(title);
        $$$setupUI$$$();
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
                coursecode = (String) courseField.getSelectedItem();
            }
        });
        mathField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                math = Double.parseDouble((String) mathField.getSelectedItem());
            }
        });
        russianField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                russian = Double.parseDouble((String) russianField.getSelectedItem());
            }
        });
        englishField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                english = Double.parseDouble((String) englishField.getSelectedItem());
            }
        });
        chemistryField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                chemistry = Double.parseDouble((String) chemistryField.getSelectedItem());
            }
        });
        physicsField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                physics = Double.parseDouble((String) physicsField.getSelectedItem());
            }
        });
        historyField.addActionListener(actionEvent -> history = Integer.parseInt((String) historyField.getSelectedItem()));
        socialStudiesField.addActionListener(actionEvent -> socialStudies = Integer.parseInt((String) socialStudiesField.getSelectedItem()));
        geographyField.addActionListener(actionEvent -> geography = Integer.parseInt((String) geographyField.getSelectedItem()));


        runkingButton.addActionListener(actionEvent -> {
            if (idField.equals("") | nameField.equals("") | surnameField.equals("")) {
                if (idField.equals("")) {
                    idLabel.setText("ID не указан!");
                } else if (nameField.equals("")) {
                    nameLabel.setText("Имя не указано!");
                } else if (surnameField.equals("")) {
                    surnameLabel.setText("Фамилия не указана!");
                }
            } else {
                id = Integer.parseInt(idField.getText());
                fullname = nameField.getText() + " " + surnameField.getText();
                avarage = (math + russian + english + chemistry + physics + history + socialStudies + geography) / 8;
                avarageResultLabel.setText(String.valueOf(avarage));
                String[] values = new String[]{String.valueOf(id), fullname, coursecode, String.valueOf(math),
                        String.valueOf(russian), String.valueOf(english), String.valueOf(chemistry),
                        String.valueOf(physics), String.valueOf(history), String.valueOf(socialStudies),
                        String.valueOf(geography), String.valueOf(avarage)};
                dftTableModel.addRow(values);
            }
        });

        transcriptButton.addActionListener(actionEvent -> resultsTextArea.setText("Система оценивания студентов\n" +
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
                "Средний балл: " + (math + russian + english + chemistry + physics + history + socialStudies
                + geography) / 8));

        deleteButton.addActionListener(actionEvent -> {
            class askedWindow extends Frame {
                askedWindow() {
                    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    setLayout(new FlowLayout());
                    setSize(350, 350);
                    JLabel askedLabel = new JLabel("Введите ID студента, которого желаете удалить");
                    add(askedLabel);
                    JTextArea askedWindowField = new JTextArea();
                    askedWindowField.setSize(300, 300);
                    add(askedWindowField);
                    JButton askedWindowButtonYes = new JButton("Да");
                    askedWindowButtonYes.addActionListener(actionEvent1 -> {
                        dftTableModel.removeRow(0);
                        dispose();
                    });
                    add(askedWindowButtonYes);
                    JButton askedWindowButtonNo = new JButton("Нет");
                    askedWindowButtonNo.addActionListener(ae -> dispose());
                    add(askedWindowButtonNo);
                    setVisible(true);
                }
            }
            SwingUtilities.invokeLater(() -> new askedWindow());
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

    private void createUIComponents() {
        String[] columnNameArray = new String[]{"ID Студента", "Имя", "Класс", "Математика", "Русский язык",
                "Английский язык", "Химия", "Физика", "История", "Обществознание", "География", "Средний балл"};
        columnsName = new LinkedList<>();
        columnsName.addAll(Arrays.asList(columnNameArray));
        dftTableModel = new DefaultTableModel();
        table1 = new JTable(dftTableModel);
        table1.setAutoCreateRowSorter(true);
        table1.setAutoCreateColumnsFromModel(true);
        for (String c : columnsName) {
            dftTableModel.addColumn(c);
        }
        table1.setVisible(true);
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        rootPanel = new JPanel();
        rootPanel.setLayout(new FormLayout("fill:d:grow,left:4dlu:noGrow,fill:d:grow", "center:d:noGrow,top:4dlu:noGrow,center:d:grow,top:5dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow"));
        rootPanel.setMaximumSize(new Dimension(21474, 21474));
        rootPanel.setMinimumSize(new Dimension(100, 100));
        rootPanel.setPreferredSize(new Dimension(1920, 800));
        rootPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        studentPanel = new JPanel();
        studentPanel.setLayout(new GridLayoutManager(19, 4, new Insets(0, 0, 0, 0), 3, 2));
        studentPanel.setMaximumSize(new Dimension(214748, 214748));
        studentPanel.setMinimumSize(new Dimension(100, 100));
        studentPanel.setName("Classes");
        studentPanel.setPreferredSize(new Dimension(500, 500));
        CellConstraints cc = new CellConstraints();
        rootPanel.add(studentPanel, cc.xy(1, 1));
        studentPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "ОЦЕНКИ СТУДЕНТА", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, null, null));
        final Spacer spacer1 = new Spacer();
        studentPanel.add(spacer1, new GridConstraints(17, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        studentPanel.add(spacer2, new GridConstraints(15, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        studentPanel.add(spacer3, new GridConstraints(13, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        studentPanel.add(spacer4, new GridConstraints(11, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        studentPanel.add(spacer5, new GridConstraints(9, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer6 = new Spacer();
        studentPanel.add(spacer6, new GridConstraints(6, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer7 = new Spacer();
        studentPanel.add(spacer7, new GridConstraints(3, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("ID Студента");
        studentPanel.add(label1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(162, 19), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Имя");
        studentPanel.add(label2, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 19), null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Фамилия");
        studentPanel.add(label3, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 19), null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Номер класса");
        studentPanel.add(label4, new GridConstraints(10, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 19), null, 0, false));
        nameField = new JTextField();
        nameField.setText("");
        studentPanel.add(nameField, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        surnameField = new JTextField();
        studentPanel.add(surnameField, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        courseField = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("");
        defaultComboBoxModel1.addElement("1");
        defaultComboBoxModel1.addElement("2");
        defaultComboBoxModel1.addElement("3");
        defaultComboBoxModel1.addElement("4");
        defaultComboBoxModel1.addElement("5");
        defaultComboBoxModel1.addElement("6");
        defaultComboBoxModel1.addElement("7");
        defaultComboBoxModel1.addElement("8");
        defaultComboBoxModel1.addElement("9");
        defaultComboBoxModel1.addElement("10");
        defaultComboBoxModel1.addElement("11");
        courseField.setModel(defaultComboBoxModel1);
        studentPanel.add(courseField, new GridConstraints(10, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        idField = new JTextField();
        studentPanel.add(idField, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        final Spacer spacer8 = new Spacer();
        studentPanel.add(spacer8, new GridConstraints(0, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("История");
        studentPanel.add(label5, new GridConstraints(14, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(183, 19), null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Обществознание");
        studentPanel.add(label6, new GridConstraints(16, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(183, 19), null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("География");
        studentPanel.add(label7, new GridConstraints(18, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(183, 19), null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Математика");
        studentPanel.add(label8, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(183, 19), null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("Русский язык");
        studentPanel.add(label9, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(183, 19), null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("Английский язык");
        studentPanel.add(label10, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(183, 19), null, 0, false));
        final JLabel label11 = new JLabel();
        label11.setText("Химия");
        studentPanel.add(label11, new GridConstraints(10, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(183, 19), null, 0, false));
        final JLabel label12 = new JLabel();
        label12.setText("Физика");
        studentPanel.add(label12, new GridConstraints(12, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(183, 19), null, 0, false));
        final JLabel label13 = new JLabel();
        label13.setText("Средняя оценка:");
        studentPanel.add(label13, new GridConstraints(12, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 19), null, 0, false));
        mathField = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("");
        defaultComboBoxModel2.addElement("1");
        defaultComboBoxModel2.addElement("2");
        defaultComboBoxModel2.addElement("3");
        defaultComboBoxModel2.addElement("4");
        defaultComboBoxModel2.addElement("5");
        mathField.setModel(defaultComboBoxModel2);
        studentPanel.add(mathField, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        russianField = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel3 = new DefaultComboBoxModel();
        defaultComboBoxModel3.addElement("");
        defaultComboBoxModel3.addElement("1");
        defaultComboBoxModel3.addElement("2");
        defaultComboBoxModel3.addElement("3");
        defaultComboBoxModel3.addElement("4");
        defaultComboBoxModel3.addElement("5");
        russianField.setModel(defaultComboBoxModel3);
        russianField.setName("");
        studentPanel.add(russianField, new GridConstraints(4, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        englishField = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel4 = new DefaultComboBoxModel();
        defaultComboBoxModel4.addElement("");
        defaultComboBoxModel4.addElement("1");
        defaultComboBoxModel4.addElement("2");
        defaultComboBoxModel4.addElement("3");
        defaultComboBoxModel4.addElement("4");
        defaultComboBoxModel4.addElement("5");
        englishField.setModel(defaultComboBoxModel4);
        studentPanel.add(englishField, new GridConstraints(7, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        chemistryField = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel5 = new DefaultComboBoxModel();
        defaultComboBoxModel5.addElement("");
        defaultComboBoxModel5.addElement("1");
        defaultComboBoxModel5.addElement("2");
        defaultComboBoxModel5.addElement("3");
        defaultComboBoxModel5.addElement("4");
        defaultComboBoxModel5.addElement("5");
        chemistryField.setModel(defaultComboBoxModel5);
        studentPanel.add(chemistryField, new GridConstraints(10, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        physicsField = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel6 = new DefaultComboBoxModel();
        defaultComboBoxModel6.addElement("");
        defaultComboBoxModel6.addElement("1");
        defaultComboBoxModel6.addElement("2");
        defaultComboBoxModel6.addElement("3");
        defaultComboBoxModel6.addElement("4");
        defaultComboBoxModel6.addElement("5");
        physicsField.setModel(defaultComboBoxModel6);
        studentPanel.add(physicsField, new GridConstraints(12, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        historyField = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel7 = new DefaultComboBoxModel();
        defaultComboBoxModel7.addElement("");
        defaultComboBoxModel7.addElement("1");
        defaultComboBoxModel7.addElement("2");
        defaultComboBoxModel7.addElement("3");
        defaultComboBoxModel7.addElement("4");
        defaultComboBoxModel7.addElement("5");
        historyField.setModel(defaultComboBoxModel7);
        studentPanel.add(historyField, new GridConstraints(14, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        socialStudiesField = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel8 = new DefaultComboBoxModel();
        defaultComboBoxModel8.addElement("");
        defaultComboBoxModel8.addElement("1");
        defaultComboBoxModel8.addElement("2");
        defaultComboBoxModel8.addElement("3");
        defaultComboBoxModel8.addElement("4");
        defaultComboBoxModel8.addElement("5");
        socialStudiesField.setModel(defaultComboBoxModel8);
        studentPanel.add(socialStudiesField, new GridConstraints(16, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        geographyField = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel9 = new DefaultComboBoxModel();
        defaultComboBoxModel9.addElement("");
        defaultComboBoxModel9.addElement("1");
        defaultComboBoxModel9.addElement("2");
        defaultComboBoxModel9.addElement("3");
        defaultComboBoxModel9.addElement("4");
        defaultComboBoxModel9.addElement("5");
        geographyField.setModel(defaultComboBoxModel9);
        studentPanel.add(geographyField, new GridConstraints(18, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        avarageResultLabel = new JLabel();
        Font avarageResultLabelFont = this.$$$getFont$$$("C059", -1, 16, avarageResultLabel.getFont());
        if (avarageResultLabelFont != null) avarageResultLabel.setFont(avarageResultLabelFont);
        avarageResultLabel.setText("");
        studentPanel.add(avarageResultLabel, new GridConstraints(12, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        idLabel = new JLabel();
        idLabel.setText("");
        studentPanel.add(idLabel, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nameLabel = new JLabel();
        nameLabel.setText("");
        studentPanel.add(nameLabel, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        surnameLabel = new JLabel();
        surnameLabel.setText("");
        studentPanel.add(surnameLabel, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gradesPanel = new JPanel();
        gradesPanel.setLayout(new CardLayout(0, 0));
        gradesPanel.setMinimumSize(new Dimension(100, 100));
        gradesPanel.setPreferredSize(new Dimension(500, 500));
        rootPanel.add(gradesPanel, cc.xy(3, 1));
        gradesPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        resultsTextArea = new JTextArea();
        Font resultsTextAreaFont = this.$$$getFont$$$("C059", -1, 20, resultsTextArea.getFont());
        if (resultsTextAreaFont != null) resultsTextArea.setFont(resultsTextAreaFont);
        resultsTextArea.setLineWrap(true);
        resultsTextArea.setRows(12);
        resultsTextArea.setSelectionEnd(124);
        resultsTextArea.setSelectionStart(124);
        resultsTextArea.setText("\nПриветствуем Вас в Системе Оценки Успеваемости Студентов (СОУС)!\nДля подсчёта успеваемости студента, заполните пустые поля.");
        resultsTextArea.setWrapStyleWord(false);
        gradesPanel.add(resultsTextArea, "Card1");
        final JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setAutoscrolls(true);
        scrollPane2.setPreferredSize(new Dimension(1380, 427));
        rootPanel.add(scrollPane2, cc.xyw(1, 3, 3, CellConstraints.CENTER, CellConstraints.CENTER));
        scrollPane2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        table1.setAutoCreateColumnsFromModel(true);
        table1.setAutoResizeMode(0);
        table1.setEditingColumn(12);
        table1.setEditingRow(1);
        table1.setEnabled(false);
        table1.setIntercellSpacing(new Dimension(1, 1));
        table1.putClientProperty("JTable.autoStartsEdit", Boolean.FALSE);
        table1.putClientProperty("Table.isFileList", Boolean.FALSE);
        table1.putClientProperty("html.disable", Boolean.FALSE);
        scrollPane2.setViewportView(table1);
        settingsPanel = new JPanel();
        settingsPanel.setLayout(new GridBagLayout());
        rootPanel.add(settingsPanel, cc.xyw(1, 7, 3));
        transcriptButton = new JButton();
        transcriptButton.setText("Подробнее");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        settingsPanel.add(transcriptButton, gbc);
        final JPanel spacer9 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        settingsPanel.add(spacer9, gbc);
        final JPanel spacer10 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        settingsPanel.add(spacer10, gbc);
        deleteButton = new JButton();
        deleteButton.setText("Удалить");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
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
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        settingsPanel.add(resetButton, gbc);
        exitButton = new JButton();
        exitButton.setText("Выход");
        gbc = new GridBagConstraints();
        gbc.gridx = 8;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        settingsPanel.add(exitButton, gbc);
        final JPanel spacer11 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        settingsPanel.add(spacer11, gbc);
        final JPanel spacer12 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        settingsPanel.add(spacer12, gbc);
        final JPanel spacer13 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        settingsPanel.add(spacer13, gbc);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }

}