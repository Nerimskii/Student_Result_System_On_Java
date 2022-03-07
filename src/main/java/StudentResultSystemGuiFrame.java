import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JScrollPane scrollPane1;
    private String name, surname, coursecode, fullname;
    private int id, math, russian, english, chemistry, physics, history,
            socialStudies, geography;
    private double avarage;
    private String[] columnsName;

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
                math = Integer.parseInt((String) mathField.getSelectedItem());
            }
        });
        russianField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                russian = Integer.parseInt((String) russianField.getSelectedItem());
            }
        });
        englishField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                english = Integer.parseInt((String) englishField.getSelectedItem());
            }
        });
        chemistryField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                chemistry = Integer.parseInt((String) chemistryField.getSelectedItem());
            }
        });
        physicsField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                physics = Integer.parseInt((String) physicsField.getSelectedItem());
            }
        });
        historyField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                history = Integer.parseInt((String) historyField.getSelectedItem());
            }
        });
        socialStudiesField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                socialStudies = Integer.parseInt((String) socialStudiesField.getSelectedItem());
            }
        });
        geographyField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                geography = Integer.parseInt((String) geographyField.getSelectedItem());
            }
        });

        columnsName = new String[]{"ID Студента", "Имя", "Класс", "Математика", "Русский язык",
                "Английский язык", "Химия", "Физика", "История", "Обществознание", "География", "Средний балл"};


        runkingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fullname = nameField.getText() + " " + surnameField.getText();
                avarage = (math + russian + english + chemistry + physics + history + socialStudies + geography) / 8;
                avarageResultLabel.setText(String.valueOf(avarage));
                String[] values = new String[]{String.valueOf(id), fullname, coursecode, String.valueOf(math),
                        String.valueOf(russian), String.valueOf(english), String.valueOf(chemistry),
                        String.valueOf(physics), String.valueOf(history), String.valueOf(socialStudies),
                        String.valueOf(geography), String.valueOf(avarage)};
                //dftTableModel.insertRow(0, values);

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
                                //tableModel.removeRow(0);
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
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new askedWindow();
                    }
                });
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

    private void createUIComponents() {
        table1 = new JTable(new DefaultTableModel());
        table1.setAutoCreateRowSorter(true);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableModel table1model = new DefaultTableModel();
        TableColumn nameColumn = new TableColumn();
        nameColumn.setHeaderValue("Имя");
        table1.addColumn(nameColumn);
        table1.addColumn(new TableColumn());
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
        rootPanel.setLayout(new FormLayout("fill:d:grow,left:4dlu:noGrow,fill:d:grow", "center:d:noGrow,top:4dlu:noGrow,center:d:grow,top:5dlu:noGrow,center:max(d;4px):noGrow"));
        rootPanel.setMaximumSize(new Dimension(21474, 21474));
        rootPanel.setMinimumSize(new Dimension(100, 100));
        rootPanel.setPreferredSize(new Dimension(1920, 800));
        rootPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        studentPanel = new JPanel();
        studentPanel.setLayout(new GridLayoutManager(16, 4, new Insets(0, 0, 0, 0), 3, 2));
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
        studentPanel.add(label1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(162, 19), null, 0, false));
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
        courseField = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
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
        studentPanel.add(courseField, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        idField = new JTextField();
        studentPanel.add(idField, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        final Spacer spacer8 = new Spacer();
        studentPanel.add(spacer8, new GridConstraints(0, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("История");
        studentPanel.add(label5, new GridConstraints(11, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(183, 19), null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Обществознание");
        studentPanel.add(label6, new GridConstraints(13, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(183, 19), null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("География");
        studentPanel.add(label7, new GridConstraints(15, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(183, 19), null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Математика");
        studentPanel.add(label8, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(183, 19), null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("Русский язык");
        studentPanel.add(label9, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(183, 19), null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("Английский язык");
        studentPanel.add(label10, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(183, 19), null, 0, false));
        final JLabel label11 = new JLabel();
        label11.setText("Химия");
        studentPanel.add(label11, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(183, 19), null, 0, false));
        final JLabel label12 = new JLabel();
        label12.setText("Физика");
        studentPanel.add(label12, new GridConstraints(9, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(183, 19), null, 0, false));
        final JLabel label13 = new JLabel();
        label13.setText("Средняя оценка:");
        studentPanel.add(label13, new GridConstraints(9, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 19), null, 0, false));
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
        studentPanel.add(russianField, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        englishField = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel4 = new DefaultComboBoxModel();
        defaultComboBoxModel4.addElement("");
        defaultComboBoxModel4.addElement("1");
        defaultComboBoxModel4.addElement("2");
        defaultComboBoxModel4.addElement("3");
        defaultComboBoxModel4.addElement("4");
        defaultComboBoxModel4.addElement("5");
        englishField.setModel(defaultComboBoxModel4);
        studentPanel.add(englishField, new GridConstraints(5, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        chemistryField = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel5 = new DefaultComboBoxModel();
        defaultComboBoxModel5.addElement("");
        defaultComboBoxModel5.addElement("1");
        defaultComboBoxModel5.addElement("2");
        defaultComboBoxModel5.addElement("3");
        defaultComboBoxModel5.addElement("4");
        defaultComboBoxModel5.addElement("5");
        chemistryField.setModel(defaultComboBoxModel5);
        studentPanel.add(chemistryField, new GridConstraints(7, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        physicsField = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel6 = new DefaultComboBoxModel();
        defaultComboBoxModel6.addElement("");
        defaultComboBoxModel6.addElement("1");
        defaultComboBoxModel6.addElement("2");
        defaultComboBoxModel6.addElement("3");
        defaultComboBoxModel6.addElement("4");
        defaultComboBoxModel6.addElement("5");
        physicsField.setModel(defaultComboBoxModel6);
        studentPanel.add(physicsField, new GridConstraints(9, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        historyField = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel7 = new DefaultComboBoxModel();
        defaultComboBoxModel7.addElement("");
        defaultComboBoxModel7.addElement("1");
        defaultComboBoxModel7.addElement("2");
        defaultComboBoxModel7.addElement("3");
        defaultComboBoxModel7.addElement("4");
        defaultComboBoxModel7.addElement("5");
        historyField.setModel(defaultComboBoxModel7);
        studentPanel.add(historyField, new GridConstraints(11, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        socialStudiesField = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel8 = new DefaultComboBoxModel();
        defaultComboBoxModel8.addElement("");
        defaultComboBoxModel8.addElement("1");
        defaultComboBoxModel8.addElement("2");
        defaultComboBoxModel8.addElement("3");
        defaultComboBoxModel8.addElement("4");
        defaultComboBoxModel8.addElement("5");
        socialStudiesField.setModel(defaultComboBoxModel8);
        studentPanel.add(socialStudiesField, new GridConstraints(13, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        geographyField = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel9 = new DefaultComboBoxModel();
        defaultComboBoxModel9.addElement("");
        defaultComboBoxModel9.addElement("1");
        defaultComboBoxModel9.addElement("2");
        defaultComboBoxModel9.addElement("3");
        defaultComboBoxModel9.addElement("4");
        defaultComboBoxModel9.addElement("5");
        geographyField.setModel(defaultComboBoxModel9);
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
        resultsTextArea.setRows(12);
        resultsTextArea.setSelectionEnd(0);
        resultsTextArea.setSelectionStart(0);
        gradesPanel.add(resultsTextArea, "Card1");
        settingsPanel = new JPanel();
        settingsPanel.setLayout(new GridBagLayout());
        rootPanel.add(settingsPanel, cc.xy(3, 5));
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
        final JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setAutoscrolls(true);
        rootPanel.add(scrollPane2, cc.xywh(1, 3, 1, 3, CellConstraints.FILL, CellConstraints.FILL));
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
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }
}