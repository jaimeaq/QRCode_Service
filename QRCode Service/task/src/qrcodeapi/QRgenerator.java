package qrcodeapi;

import java.awt.image.BufferedImage;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.http.HttpStatus;

public class QRgenerator {
    public static BufferedImage generate (QRRequest qrRequest) {
        QRCodeWriter writer = new QRCodeWriter();
        Map<EncodeHintType, ?> hints = Map.of(EncodeHintType.ERROR_CORRECTION, qrRequest.getErrorCorrectionLevel());

        try {
            BitMatrix bitMatrix = writer.encode(
                    qrRequest.getContents(),
                    BarcodeFormat.QR_CODE,
                    qrRequest.getSize(),
                    qrRequest.getSize(),
                    hints
            );
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (WriterException e) {
            new ErrorResponseDTO(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            return null;
        }
    }
}
