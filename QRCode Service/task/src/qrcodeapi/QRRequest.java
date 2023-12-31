package qrcodeapi;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.http.MediaType;

import javax.print.attribute.standard.Media;

public class QRRequest {
    private final String contents;
    private final int size;
    private final String imageFormat;
    private MediaType mediaType;
    private final String correction;
    private ErrorCorrectionLevel errorCorrectionLevel;

    public QRRequest(String contents, int size, String imageFormat, String correction) {
        this.contents = contents;
        this.size = size;
        this.imageFormat = imageFormat;
        this.correction = correction;
    }

    public String getContents() {
        return contents;
    }

    public int getSize() {
        return size;
    }

    public String getImageFormat() {
        return imageFormat;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public String getCorrection() {
        return correction;
    }

    public ErrorCorrectionLevel getErrorCorrectionLevel() {
        return errorCorrectionLevel;
    }

    public void setErrorCorrectionLevel(ErrorCorrectionLevel errorCorrectionLevel) {
        this.errorCorrectionLevel = errorCorrectionLevel;
    }
}
