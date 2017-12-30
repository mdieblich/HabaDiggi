package com.dieblich.handball.gatecom;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

class GatecomFile {

    private static final Charset FILE_ENCODING = Charset.forName("CP1252");
    private File file;

    GatecomFile(String filename) throws GatecomException {
        file = new File(filename);
        if (!file.exists()) {
            throw new GatecomException("File \"" + filename + "\" does not exist");
        }
    }

    public GatecomGame extractGame() throws GatecomException {
        GatecomGame extractedGame = new GatecomGame();
        try {
            List<String> lines = Files.readAllLines(file.toPath(), FILE_ENCODING);
            extractedGame.setLigaKey(lines.get(0));
            extractedGame.setLigaName(lines.get(1));

        } catch (IOException e) {
            throw new GatecomException("Could not read from \"" + file.getPath() + "\"", e);
        }
        return extractedGame;
    }
}
