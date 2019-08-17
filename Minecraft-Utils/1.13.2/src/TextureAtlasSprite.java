public class TextureAtlasSprite extends ddm {

	public static final TextureAtlasSprite MISSING_NO = new TextureAtlasSprite("missingno");

	protected TextureAtlasSprite(String s) {
		super(new ResourceLocation(s), 0, 0);
	}
}
