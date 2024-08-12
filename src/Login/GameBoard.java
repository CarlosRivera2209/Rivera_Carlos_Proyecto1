package Login;

import javax.swing.*;
import java.awt.*;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Calendar;

public class GameBoard extends JFrame {

    private Character[] characters;
    private JButton[][] buttons = new JButton[10][10];
    private JButton resignGame = new JButton("");
    private JButton[] eliminatedHeroesButton = new JButton[40];
    private JButton[] eliminatedVillainsButton = new JButton[40];
    private String cardBackgroundImages = "./src/Login/images/Who_question_mark.png";
    private String[] originalButtonImages;
    private boolean isHeroTurn = true;
    private ArrayList<Character> heroes = new ArrayList<>();
    private ArrayList<Character> villains = new ArrayList<>();
    private ArrayList<String> heroesOriginalImages = new ArrayList<>();
    private ArrayList<String> villainsOriginalImages = new ArrayList<>();
    private PrintStream printStream;
    private Boolean gameHasInit = false;
    private Boolean gameEndedOnNoPieces = false;
    JPanel eliminatedHeroesPanel = new JPanel(new GridLayout(10, 10));
    JPanel eliminatedVillainsPanel = new JPanel(new GridLayout(10, 10));

    JLabel User = new JLabel();
    JLabel User2 = new JLabel();

    public void close() {
        InitCharacters.getInstance().setInitCharactersNull();
        dispose();
    }

    List<Character> eliminatedHeroes = new ArrayList<>();
    List<Character> eliminatedVillains = new ArrayList<>();

    private int heroesScore = 0;
    private int villainsScore = 0;
    Variables NombredeUsuario = new Variables();

    private void loadOriginalButtonImages() {
        originalButtonImages = new String[characters.length];
        int contCharacter = 0;
        for (int i = 0; i < characters.length; i++) {
            if (characters[i].isHero()) {
                heroes.add(characters[i]);
                heroesOriginalImages.add(characters[i].getImage().getDescription());
            } else {
                villains.add(characters[i]);
                villainsOriginalImages.add(characters[i].getImage().getDescription());
            }

            contCharacter++;
        }
    }

    public GameBoard() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] options = {"SÍ", "NO"};

        int choice = JOptionPane.showOptionDialog(
                this,
                "¿Quieres jugar con héroes?",
                "Confirmar bando",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.DARK_GRAY);
        UI.put("OptionPane.messageForeground", Color.BLACK);

        if (choice != JOptionPane.YES_OPTION) {
            isHeroTurn = false;
        }
        setTitle("Stratego - Marvel Heroes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); 

        JPanel gameBoardPanel = new JPanel(new GridLayout(10, 10));
        gameBoardPanel.setPreferredSize(new Dimension(1200, 800));

        characters = InitCharacters.getInstance().getCharacters();
        loadOriginalButtonImages();
        Color backgroundColor = new Color(45, 45, 45); 
        Color buttonBorderColor = new Color(70, 70, 70); 

        getContentPane().setBackground(backgroundColor);

        gameBoardPanel.setPreferredSize(new Dimension(1200, 800));
        gameBoardPanel.setBackground(backgroundColor); 

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                buttons[row][col] = createGameSpace(row, col);
                buttons[row][col].setBackground(backgroundColor);
                buttons[row][col].setBorder(BorderFactory.createLineBorder(buttonBorderColor, 1));
                boolean isYellowZone = (row >= 4 && row <= 5 && col >= 2 && col <= 3);
                boolean isMagentaZone = (row >= 4 && row <= 5 && col >= 6 && col <= 7);

                if (isYellowZone || isMagentaZone) {
                    buttons[row][col].setBackground(isYellowZone ? Color.YELLOW : Color.MAGENTA);
                    buttons[row][col].setOpaque(true);
                    buttons[row][col].setEnabled(false);
                } else {
                    buttons[row][col].setBackground(backgroundColor);
                }
                gameBoardPanel.add(buttons[row][col]);
                buttons[row][col].setBorder(BorderFactory.createLineBorder(Color.white, 1));
            }
        }

        add(gameBoardPanel, BorderLayout.CENTER);
        String imagePath = "./src/Login/images/resign.png";

        resignGame.setIcon(null);
        resignGame.setText("Resign");
        resignGame.setBackground(Color.RED);
        resignGame.setForeground(Color.BLACK);

        Dimension reducedSize = new Dimension(100, 40);
        resignGame.setPreferredSize(reducedSize);

        add(resignGame, BorderLayout.SOUTH);

        updatePanels();

        JTextArea textArea = new JTextArea(24, 80);
        textArea.setEditable(false);
        textArea.setBackground(backgroundColor);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        resignGame.addActionListener(e -> endGame());

        JPanel userPanel = new JPanel(new GridLayout(1, 2));

        if (choice == 1) {
            User.setText("VILLANO: " + NombredeUsuario.getUser());
            User2.setText("HEROE: " + NombredeUsuario.getUser2());
        } else {
            User.setText("HEROE: " + NombredeUsuario.getUser());
            User2.setText("VILLANO: " + NombredeUsuario.getUser2());
        }

        userPanel.add(User, BorderLayout.WEST);
        userPanel.add(User2, BorderLayout.EAST);

        User.setForeground(Color.BLACK);
        User2.setForeground(Color.BLACK);

        add(userPanel, BorderLayout.NORTH);
    }

    public void updatePanels() {
        Color panelBackgroundColor = Color.BLACK;
        Color borderColor = Color.WHITE;

        eliminatedHeroesPanel.removeAll();
        eliminatedHeroesPanel.setBackground(panelBackgroundColor);
        eliminatedHeroesPanel.setBorder(BorderFactory.createLineBorder(borderColor, 10));
        heroes.stream()
                .filter(hero -> !hero.isAlive())
                .forEach(hero -> {
                    int index = hero.getMyHeroCont();
                    if (index < heroesOriginalImages.size()) {
                        JLabel label = new JLabel(new ImageIcon(heroesOriginalImages.get(index)));
                        label.setBackground(panelBackgroundColor);
                        label.setOpaque(true);
                        eliminatedHeroesPanel.add(label);
                    }
                });
        add(eliminatedHeroesPanel, BorderLayout.EAST);

        eliminatedVillainsPanel.removeAll();
        eliminatedVillainsPanel.setBackground(panelBackgroundColor); 
        eliminatedVillainsPanel.setBorder(BorderFactory.createLineBorder(borderColor, 10));
        villains.stream()
                .filter(villain -> !villain.isAlive())
                .forEach(villain -> {
                    int index = villain.getMyVillainCont();
                    if (index < villainsOriginalImages.size()) {
                        JLabel label = new JLabel(new ImageIcon(villainsOriginalImages.get(index)));
                        label.setBackground(panelBackgroundColor);
                        label.setOpaque(true);
                        eliminatedVillainsPanel.add(label);
                    }
                });
        add(eliminatedVillainsPanel, BorderLayout.WEST);
        Boolean shouldEndForVillain = false;
        Boolean shouldEndForHero = false;
        List<String> excludeNames = Arrays.asList("Pumpkin", "Bomb Nova Blast", "Tierra", "Planet Tierra");

        for (Character hero : heroes) {
            if (!excludeNames.contains(hero.getName()) && hero.isAlive() && hero.getMoveable()) {
                shouldEndForVillain = true;
            }
        }
        for (Character villain : villains) {
            if (!excludeNames.contains(villain.getName()) && villain.isAlive() && villain.getMoveable()) {
                shouldEndForHero = true;
            }
        }

        revalidate(); 
        if (!shouldEndForHero || !shouldEndForVillain) {
            gameEndedOnNoPieces = true;
            endGame();
        }
        repaint(); 
    }

    private JButton createGameSpace(int row, int col) {
        JButton button = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Character character : characters) {
                    if (character.isAlive() && character.getX() == row && character.getY() == col) {
                        ImageIcon image = character.getImage();
                        if (image != null) {
                            int x = (getWidth() - image.getIconWidth()) / 2;
                            int y = (getHeight() - image.getIconHeight()) / 2;
                            g.drawImage(image.getImage(), x, y, null);
                            if (character.isHero()) {
                                setBorder(BorderFactory.createLineBorder(Color.ORANGE, 1));
                            } else {
                                setBorder(BorderFactory.createLineBorder(Color.blue, 1));
                            }
                            if (character == selectedCharacter) {
                                setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                            }
                        }
                    }
                }
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(50, 50);
            }

            @Override
            public Dimension getMinimumSize() {
                return new Dimension(50, 50);
            }

            @Override
            public Dimension getMaximumSize() {
                return new Dimension(50, 50);
            }
        };

        boolean isYellowZone = (row >= 4 && row <= 5 && col >= 2 && col <= 3);
        boolean isMagentaZone = (row >= 4 && row <= 5 && col >= 6 && col <= 7);

        if (isYellowZone || isMagentaZone) {
            button.setBackground(isYellowZone ? Color.YELLOW : Color.MAGENTA);
            button.setEnabled(false);
        }

        button.addActionListener(e -> handleButtonClick(row, col));

        return button;
    }

    private Character selectedCharacter = null;

    private void handleButtonClick(int row, int col) {
        System.out.println("Clicked on row " + row + ", column " + col);
        gameHasInit = true;

        if (selectedCharacter != null) {
            handleCharacterMove(row, col);
        } else {
            handleCharacterSelection(row, col);
        }
    }

    private void handleCharacterMove(int row, int col) {
        if (selectedCharacter.getX() == row && selectedCharacter.getY() == col) {
            handleCharacterDeselection(row, col);
        } else {
            boolean isEmpty = isCellEmpty(row, col);

            boolean isAdjacent = (selectedCharacter.getX() == row && Math.abs(selectedCharacter.getY() - col) == 1)
                    || (selectedCharacter.getY() == col && Math.abs(selectedCharacter.getX() - row) == 1);

            boolean canMove = isAdjacent;

            if (selectedCharacter.getPowerRating() == 2 && !isAdjacent) {
                canMove = (selectedCharacter.getX() == row || selectedCharacter.getY() == col)
                        && isPathClear(selectedCharacter.getX(), selectedCharacter.getY(), row, col);
            }

            if (isEmpty && canMove) {
                Character targetCharacter = getCharacterAtLocation(row, col);

                moveCharacter(row, col);

                isHeroTurn = !isHeroTurn;
            } else if (isAdjacent || selectedCharacter.getPowerRating() == 2) {
                Character targetCharacter = getCharacterAtLocation(row, col);

                if (targetCharacter != null) {

                    if (selectedCharacter.isHero() != targetCharacter.isHero()) {
                        try {
                            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        String[] options = {"Confirmar", "Cancelar"};

                        int choice = JOptionPane.showOptionDialog(
                                this,
                                "¿Estás seguro de que quieres luchar?",
                                "Confirmar lucha",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[1]
                        );

                        UIManager UI = new UIManager();
                        UI.put("OptionPane.background", Color.DARK_GRAY);
                        UI.put("OptionPane.messageForeground", Color.BLACK);

                        if (choice == JOptionPane.YES_OPTION) {
                            String heroe = "";
                            String Villano = "";
                            int finderH = 0;
                            int finderV = 0;
                            SimpleDateFormat fecha = new SimpleDateFormat("MM/YY");
                            Calendar hola = Calendar.getInstance();
                            if (User.getText().contains("HEROE")) {
                                heroe = User.getText();
                                Villano = User2.getText();

                            } else if ((User.getText().contains("VILLANO"))) {
                                heroe = User2.getText();
                                Villano = User.getText();
                            }
                            System.out.println(heroe);
                            System.out.println(Villano);
                            for (int contar = 0; contar < NombredeUsuario.getNombredeUsuario().size(); contar++) {

                                if (heroe.contains(NombredeUsuario.getNombredeUsuario().get(contar))) {
                                    finderH = contar;
                                } else if (Villano.contains(NombredeUsuario.getNombredeUsuario().get(contar))) {
                                    finderV = contar;
                                }
                            }

                            if (targetCharacter.getName().equals("Tierra")) {
                                NombredeUsuario.getPuntos().set(finderV, (NombredeUsuario.getPuntos().get(finderV) + 3));
                                NombredeUsuario.getPG_VILLAINS().set(finderV, (NombredeUsuario.getPG_VILLAINS().get(finderV) + 1));
                                JOptionPane.showMessageDialog(this, "Villains win! + 3 points");
                                NombredeUsuario.getLogs().add("A " + heroe + " le conquistaron el planeta tierra. EL ganador " + Villano + " el "+ fecha.format(hola.getTime()));

                                close();
                                new MenuPrincipal().setVisible(true);

                            } else if (targetCharacter.getName().equals("Planet Tierra")) {
                                NombredeUsuario.getPuntos().set(finderH, (NombredeUsuario.getPuntos().get(finderH) + 3));
                                NombredeUsuario.getPG_HEROES().set(finderH, (NombredeUsuario.getPG_HEROES().get(finderH) + 1));
                                JOptionPane.showMessageDialog(this, "Heroes win! +3 points");
                                NombredeUsuario.getLogs().add("A " + Villano + " le conquistaron el planeta tierra. EL ganador " + heroe + " el " + fecha.format(hola.getTime()));

                                close();
                                new MenuPrincipal().setVisible(true);

                            } else if ((selectedCharacter.getPowerRating() != 3
                                    && (targetCharacter.getName().equals("Nova Blast")
                                    || targetCharacter.getName().equals("Pumpkin Bomb")))) {
                                if ((!targetCharacter.isHero() && isHeroTurn)
                                        || (targetCharacter.isHero() && !isHeroTurn)) {
                                    List<Character> charactersToEliminate = new ArrayList<>();
                                    charactersToEliminate.add(targetCharacter);
                                    buttons[targetCharacter.getX()][targetCharacter.getY()]
                                            .setBorder(BorderFactory.createLineBorder(Color.white, 1));
                                    charactersToEliminate.add(selectedCharacter);
                                    buttons[selectedCharacter.getX()][selectedCharacter.getY()]
                                            .setBorder(BorderFactory.createLineBorder(Color.white, 1));
                                    for (Character character : charactersToEliminate) {
                                        eliminateCharacter(character, false, true);
                                    }

                                    selectedCharacter = null;
                                    changeCardBackgrounds();
                                    updatePanels();
                                    revalidate();
                                    repaint();
                                    isHeroTurn = !isHeroTurn;

                                }
                            } else if (selectedCharacter.getPowerRating() == 2) {
                                if (selectedCharacter.getX() == row || selectedCharacter.getY() == col) {
                                    int xDirection = Integer.compare(row, selectedCharacter.getX());
                                    int yDirection = Integer.compare(col, selectedCharacter.getY());

                                    int x = selectedCharacter.getX() + xDirection;
                                    int y = selectedCharacter.getY() + yDirection;

                                    while (x != row || y != col) {
                                        Character intermediateCharacter = getCharacterAtLocation(x, y);
                                        if (intermediateCharacter != null) {
                                            JOptionPane.showMessageDialog(this, "MOVIMIENTO INCORRECTO");
                                            return;
                                        }

                                        x += xDirection;
                                        y += yDirection;
                                    }

                                    targetCharacter = getCharacterAtLocation(row, col);
                                    if (targetCharacter != null) {
                                        if (selectedCharacter.isHero() == targetCharacter.isHero()) {
                                            JOptionPane.showMessageDialog(this, "MOVIMIENTO INCORRECTO");
                                            return;
                                        } else if (selectedCharacter.getPowerRating() == targetCharacter
                                                .getPowerRating()) {
                                            List<Character> charactersToEliminate = new ArrayList<>();
                                            charactersToEliminate.add(targetCharacter);
                                            buttons[targetCharacter.getX()][targetCharacter.getY()]
                                                    .setBorder(BorderFactory.createLineBorder(Color.white, 1));
                                            charactersToEliminate.add(selectedCharacter);
                                            buttons[selectedCharacter.getX()][selectedCharacter.getY()]
                                                    .setBorder(BorderFactory.createLineBorder(Color.white, 1));
                                            for (Character character : charactersToEliminate) {
                                                eliminateCharacter(character, false, true);
                                            }

                                            selectedCharacter = null;
                                            changeCardBackgrounds();
                                            updatePanels();
                                            revalidate();
                                            repaint();
                                            isHeroTurn = !isHeroTurn;
                                        } else if (selectedCharacter.getPowerRating() > targetCharacter
                                                .getPowerRating()) {
                                            eliminateCharacter(targetCharacter, false, false);
                                            moveCharacter(row, col);
                                            isHeroTurn = !isHeroTurn;
                                        } else {
                                            eliminateCharacter(selectedCharacter, true, false);
                                            selectedCharacter = null;
                                            changeCardBackgrounds();
                                            revalidate();
                                            repaint();
                                            isHeroTurn = !isHeroTurn;
                                        }
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(this, "MOVIMIENTO INCORRECTO");
                                    return;
                                }
                            } else if (selectedCharacter.getPowerRating() > targetCharacter.getPowerRating()
                                    || (selectedCharacter.getPowerRating() == 3
                                    && (targetCharacter.getName().equals("Nova Blast")
                                    || targetCharacter.getName().equals("Pumpkin Bomb")))
                                    || (selectedCharacter.getPowerRating() == 1
                                    && targetCharacter.getPowerRating() == 10)) {
                                if ((!targetCharacter.isHero() && isHeroTurn)
                                        || (targetCharacter.isHero() && !isHeroTurn)) {
                                    eliminateCharacter(targetCharacter, false, false);
                                    moveCharacter(row, col);
                                    isHeroTurn = !isHeroTurn;
                                }
                            } else if (selectedCharacter.getPowerRating() < targetCharacter.getPowerRating()) {
                                eliminateCharacter(selectedCharacter, true, false);
                                selectedCharacter = null;
                                changeCardBackgrounds();
                                updatePanels();
                                revalidate();
                                repaint();
                                isHeroTurn = !isHeroTurn;
                            } else if (selectedCharacter.getPowerRating() == targetCharacter.getPowerRating()) {
                                List<Character> charactersToEliminate = new ArrayList<>();
                                charactersToEliminate.add(targetCharacter);
                                buttons[targetCharacter.getX()][targetCharacter.getY()]
                                        .setBorder(BorderFactory.createLineBorder(Color.white, 1));
                                charactersToEliminate.add(selectedCharacter);
                                buttons[selectedCharacter.getX()][selectedCharacter.getY()]
                                        .setBorder(BorderFactory.createLineBorder(Color.white, 1));
                                for (Character character : charactersToEliminate) {
                                    eliminateCharacter(character, false, true);
                                }

                                selectedCharacter = null;
                                changeCardBackgrounds();
                                updatePanels();
                                revalidate();
                                repaint();
                                isHeroTurn = !isHeroTurn;

                            } else if (selectedCharacter.getPowerRating() == 1) {

                            } else {
                                JOptionPane.showMessageDialog(this, "MOVIMIENTO INCORRECTO");
                            }
                        } else {
                            selectedCharacter = null;
                        }
                    }
                }

            }
        }
    }

    private void endGame() {

        String heroe = "";
        String Villano = "";
        int finderH = 0;
        int finderV = 0;
        Calendar hola = Calendar.getInstance();
        SimpleDateFormat fecha = new SimpleDateFormat("MM/YY");
        if (User.getText().contains("HEROE")) {
            heroe = User.getText();
            Villano = User2.getText();

        } else if ((User.getText().contains("VILLANO"))) {
            heroe = User2.getText();
            Villano = User.getText();
        }

        for (int contar = 0; contar < NombredeUsuario.getNombredeUsuario().size(); contar++) {
            if (heroe.contains(NombredeUsuario.getNombredeUsuario().get(contar))) {
                finderH = contar;
            } else if (Villano.contains(NombredeUsuario.getNombredeUsuario().get(contar))) {
                finderV = contar;
            }
        }

        if (isHeroTurn || (!isHeroTurn && gameHasInit) || (isHeroTurn && gameEndedOnNoPieces)) {
            JOptionPane.showMessageDialog(this, "Villains win! + 3 points");
            NombredeUsuario.getPuntos().set(finderV, (NombredeUsuario.getPuntos().get(finderV) + 3));
            NombredeUsuario.getLogs().add(heroe + " se rindio. EL ganador es " + Villano + " el " + fecha.format(hola.getTime()));
            NombredeUsuario.getPG_VILLAINS().set(finderV, (NombredeUsuario.getPG_VILLAINS().get(finderV) + 1));

        } else {
            JOptionPane.showMessageDialog(this, "Heroes win! +3 points");
            NombredeUsuario.getPuntos().set(finderH, (NombredeUsuario.getPuntos().get(finderH) + 3));
            NombredeUsuario.getLogs().add(Villano + " se rindio. EL ganador es" + heroe +" el " +  fecha.format(hola.getTime()));
            NombredeUsuario.getPG_HEROES().set(finderH, (NombredeUsuario.getPG_HEROES().get(finderH) + 1));
        }
        close();
        new MenuPrincipal().setVisible(true);
    }

    private boolean isPathClear(int startX, int startY, int endX, int endY) {
        int xDirection = startX == endX ? 0 : (endX - startX) / Math.abs(endX - startX);
        int yDirection = startY == endY ? 0 : (endY - startY) / Math.abs(endY - startY);

        for (int i = 1; i < Math.max(Math.abs(endX - startX), Math.abs(endY - startY)); i++) {
            if (!isCellEmpty(startX + i * xDirection, startY + i * yDirection)) {
                return false;
            }
        }

        return true;
    }

    private void handleCharacterSelection(int row, int col) {
        for (Character character : characters) {
            if (character.getX() == row && character.getY() == col && character.getMoveable()) {
                if ((character.isHero() && isHeroTurn) || (!character.isHero() && !isHeroTurn)) {
                    selectCharacter(row, col, character);
                    break;
                }
            }
        }
    }

    private void handleCharacterDeselection(int row, int col) {
        buttons[row][col]
                .setBorder(BorderFactory.createLineBorder(selectedCharacter.isHero() ? Color.ORANGE : Color.blue, 1));

        selectedCharacter = null;
    }

    private boolean isCellEmpty(int row, int col) {
        for (Character character : characters) {
            if (character.getX() == row && character.getY() == col) {
                return false;
            }
        }
        return true;
    }

    private void moveCharacter(int row, int col) {
        int oldX = selectedCharacter.getX();
        int oldY = selectedCharacter.getY();

        selectedCharacter.setX(row);
        selectedCharacter.setY(col);
        buttons[row][col]
                .setBorder(BorderFactory.createLineBorder(selectedCharacter.isHero() ? Color.ORANGE : Color.blue, 1));

        buttons[oldX][oldY].setBorder(BorderFactory.createLineBorder(Color.white, 1));

        selectedCharacter = null;
        changeCardBackgrounds();
        revalidate();
        repaint();
    }

    private void selectCharacter(int row, int col, Character character) {
        selectedCharacter = character;
        System.out.println("Found character: " + character.getName());
        buttons[row][col].setBorder(BorderFactory.createLineBorder(Color.GREEN, 10));
    }

    private Character getCharacterAtLocation(int row, int col) {
        for (Character character : characters) {
            if (character.getX() == row && character.getY() == col) {
                return character;
            }
        }
        return null;
    }

    private void eliminateCharacter(Character character, boolean deathByBomb, boolean mutualElim) {

        buttons[selectedCharacter.getX()][selectedCharacter.getY()]
                .setBorder(BorderFactory.createLineBorder(Color.white, 1));
        character.setAlive(false);
        character.setX(-1);
        character.setY(-1);
        if (!mutualElim) {
            if (character.isHero()) {
                eliminatedHeroes.add(character);
                heroesScore += 5;
            } else {
                eliminatedVillains.add(character);
                villainsScore += 5;
            }
            updatePanels();
            revalidate();
            repaint();
        }

    }

    private void styleButton(JButton button, Color color, Font font) {
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(font);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
    }

    private void changeCardBackgrounds() {
        int contCharacterVillain = 0;
        int contCharacterHero = 0;
        if (isHeroTurn) {
            for (Character character : heroes) {
                character.setImage(cardBackgroundImages);
            }
            for (Character character : villains) {
                character.setImage(villainsOriginalImages.get(contCharacterVillain));
                contCharacterVillain++;
            }

        }
        if (!isHeroTurn) {
            for (Character character : villains) {
                character.setImage(cardBackgroundImages);
            }
            for (Character character : heroes) {
                character.setImage(heroesOriginalImages.get(contCharacterHero));
                contCharacterHero++;
            }
        }
    }



}
