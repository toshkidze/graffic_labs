package classes;

import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.TextureLoader;

import javax.media.j3d.Appearance;
import javax.media.j3d.Material;
import javax.media.j3d.Texture;
import javax.media.j3d.TextureAttributes;
import javax.vecmath.Color3f;
import javax.vecmath.Color4f;
import java.awt.*;

public class BookBuilder {

        public static Box getCover(float x, float y, float z) {
                int primitive_flags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
                return new Box(x, y, z, primitive_flags, getCoverAppearance());
        }

        public static Box getWritten(float x, float y, float z) {
                int primitive_flags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
                return new Box(x, y, z, primitive_flags, getWrittenAppearance());
        }
        public static Box getBookEnd(float x, float y, float z) {
                int primitive_flags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
                return new Box(x, y, z, primitive_flags, getRedAppearance());
        }

        public static Box getSide(float x, float y, float z) {
                int primitive_flags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
                return new Box(x, y, z, primitive_flags, getSideAppearance());
        }

        private static Appearance getCoverAppearance() {
                TextureLoader loader = new TextureLoader("src\\textures\\leather.jpg", "LUMINANCE", new Container());
                Appearance ap = new Appearance();

                Texture texture = loader.getTexture();
                texture.setBoundaryModeS(Texture.WRAP);
                texture.setBoundaryModeT(Texture.WRAP);
                texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));

                TextureAttributes texAttr = new TextureAttributes();
                texAttr.setTextureMode(TextureAttributes.MODULATE);

                ap.setTexture(texture);
                ap.setTextureAttributes(texAttr);

                Color3f emissive = new Color3f(new Color(69, 29, 0));
                Color3f ambient = new Color3f(new Color(119, 41, 0));
                Color3f diffuse = new Color3f();
                Color3f specular = new Color3f(new Color(0, 0, 0));
                ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
                return ap;
        }

        private static Appearance getWrittenAppearance() {
                TextureLoader loader = new TextureLoader("src\\textures\\poem.png", "LUMINANCE", new Container());
                Appearance ap = new Appearance();
                Texture texture = loader.getTexture();
                texture.setBoundaryModeS(Texture.WRAP);
                texture.setBoundaryModeT(Texture.WRAP);
                texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));

                TextureAttributes texAttr = new TextureAttributes();
                texAttr.setTextureMode(TextureAttributes.MODULATE);

                ap.setTexture(texture);
                ap.setTextureAttributes(texAttr);

                Color3f emissive = new Color3f(new Color(249, 255, 246, 240));
                Color3f ambient = new Color3f(new Color(255, 255, 255, 255));
                Color3f diffuse = new Color3f();
                Color3f specular = new Color3f(new Color(0, 0, 0));
                ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
                return ap;
        }

        private static Appearance getSideAppearance() {
                TextureLoader loader = new TextureLoader("src\\textures\\buttons.jpg", "LUMINANCE", new Container());
                Appearance ap = new Appearance();
                Texture texture = loader.getTexture();
                texture.setBoundaryModeS(Texture.WRAP);
                texture.setBoundaryModeT(Texture.WRAP);
                texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));

                TextureAttributes texAttr = new TextureAttributes();
                texAttr.setTextureMode(TextureAttributes.MODULATE);

                ap.setTexture(texture);
                ap.setTextureAttributes(texAttr);

                Color3f emissive = new Color3f(new Color(249, 255, 246, 240));
                Color3f ambient = new Color3f(new Color(255, 255, 255, 255));
                Color3f diffuse = new Color3f();
                Color3f specular = new Color3f(new Color(0, 0, 0));
                ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
                return ap;
        }

        private static Appearance getRedAppearance() {
                TextureLoader loader = new TextureLoader("src\\textures\\cd.jpg", "LUMINANCE", new Container());
                Appearance ap = new Appearance();
                Texture texture = loader.getTexture();
                texture.setBoundaryModeS(Texture.WRAP);
                texture.setBoundaryModeT(Texture.WRAP);
                texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));

                TextureAttributes texAttr = new TextureAttributes();
                texAttr.setTextureMode(TextureAttributes.MODULATE);

                ap.setTexture(texture);
                ap.setTextureAttributes(texAttr);

                Color3f emissive = new Color3f(new Color(71, 5, 0, 255));
                Color3f ambient = new Color3f(new Color(71, 5, 0, 255));
                Color3f diffuse = new Color3f();
                Color3f specular = new Color3f(new Color(115, 8, 0, 255));
                ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
                return ap;
        }


}
