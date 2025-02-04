package bacit.web.Servlet.Models;

import java.util.Arrays;

public class FileModel {

    private String name;
    private byte[] contents;
    private String contentType;

    public FileModel(String name, byte[] contents, String contentType) {
        this.name = name;
        this.contents = contents;
        this.contentType = contentType;
    }

    public FileModel(int id, String name) {
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContents() {
        return contents;
    }

    public void setContents(byte[] contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "FileModel{" +
                "name='" + name + '\'' +
                ", contents=" + Arrays.toString(contents) +
                ", contentType='" + contentType + '\'' +
                '}';
    }
}


