import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SimpleTexture extends ddi {

	private boolean textureUploaded;
	private BufferedImage bufferedImage;

	public SimpleTexture() {
		super(null);
	}

	void checkTextureUploaded() {
		if (!this.textureUploaded) {
			if (this.bufferedImage != null) {
				try {
					ByteArrayOutputStream os = new ByteArrayOutputStream();
					ImageIO.write(bufferedImage, "png", os);
					InputStream in = new ByteArrayInputStream(os.toByteArray());
					ddg var1 = ddg.a(in);
					ddp.a(super.c(), var1.a(), var1.b());
					var1.a(0, 0, 0, false);
					this.textureUploaded = true;
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	public void setBufferedImage(BufferedImage bufferedImage) {
		this.textureUploaded = false;
		this.bufferedImage = bufferedImage;
	}

	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	@Override
	public int c() {
		checkTextureUploaded();
		return super.c();
	}

	@Override
	public void a(vf resourceManager) throws IOException {
	}
}
