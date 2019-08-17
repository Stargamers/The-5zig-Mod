import eu.the5zig.mod.util.IResourceLocation;

import java.util.Locale;

public class ResourceLocation extends qs implements IResourceLocation {

	public ResourceLocation(String resourcePath) {
		super(resourcePath.toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9/._-]", ""));
	}

	public ResourceLocation(String resourceDomain, String resourcePath) {
		super(resourceDomain, resourcePath.toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9/._-]", ""));
	}

	public static ResourceLocation fromObfuscated(qs resourceLocation) {
		return new ResourceLocation(resourceLocation.b(), resourceLocation.a());
	}

	public String getResourcePath() {
		return a();
	}

	public String getResourceDomain() {
		return b();
	}

	@Override
	public int compareTo(qs qs) {
		return a(qs);
	}
}
