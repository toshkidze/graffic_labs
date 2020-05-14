import javax.vecmath.*;

import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import com.sun.j3d.utils.behaviors.vp.*;
import javax.swing.JFrame;

import com.sun.j3d.loaders.*;
import com.sun.j3d.loaders.objectfile.*;

import java.awt.*;
import java.util.Hashtable;
import java.util.Enumeration;

public class Fish extends JFrame{
    public Canvas3D myCanvas3D;

    public Fish(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myCanvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
        SimpleUniverse simpUniv = new SimpleUniverse(myCanvas3D);

        simpUniv.getViewingPlatform().setNominalViewingTransform();

        createSceneGraph(simpUniv);
        addLight(simpUniv);

        OrbitBehavior ob = new OrbitBehavior(myCanvas3D);
        ob.setSchedulingBounds(new BoundingSphere(new Point3d(0.0,0.0,0.0),Double.MAX_VALUE));
        simpUniv.getViewingPlatform().setViewPlatformBehavior(ob);

        setTitle("Fish");
        setSize(700,700);
        getContentPane().add("Center", myCanvas3D);
        setVisible(true);
    }

    Material getMaterialForBody() {
        Material material = new Material();
        material.setAmbientColor ( new Color3f(new Color(0xE01805FF, true)) );
        material.setDiffuseColor ( new Color3f(new Color(0xE01805FF, true)) );
        material.setSpecularColor( new Color3f(new Color(0xE01805FF, true)) );
        material.setShininess( 0.3f );
        material.setLightingEnable(true);
        return material;
    }

    Material getMaterialForParts() {
        Material material = new Material();
        material.setAmbientColor ( new Color3f(new Color(0xDF040035, true)) );
        material.setDiffuseColor ( new Color3f(new Color(0xDF040035, true)) );
        material.setSpecularColor( new Color3f(new Color(0xDF040035, true)) );
        material.setShininess( 0.3f );
        material.setLightingEnable(true);
        return material;
    }

    Texture getTexture(String path) {
        TextureLoader textureLoader = new TextureLoader(path,"LUMINANCE",myCanvas3D);
        Texture texture = textureLoader.getTexture();
        return texture;
    }

    private Appearance getForBody(){
        Appearance appearance = new Appearance();
        appearance.setTexture(getTexture("source_folder//body.jpg"));
        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.COMBINE);
        appearance.setTextureAttributes(texAttr);
        appearance.setMaterial(getMaterialForBody());
        return appearance;
    }

    private Appearance getForParts(){
        Appearance appearance = new Appearance();
        appearance.setTexture(getTexture("source_folder//parts.jpg"));
        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.COMBINE);
        appearance.setTextureAttributes(texAttr);
        appearance.setMaterial(getMaterialForParts());
        return appearance;
    }

    private Appearance getForEyes(){
        Appearance appearance = new Appearance();
        appearance.setTexture(getTexture("source_folder//black.jpg"));
        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.COMBINE);
        appearance.setTextureAttributes(texAttr);
        return appearance;
    }


    public void createSceneGraph(SimpleUniverse su){
        ObjectFile f = new ObjectFile(ObjectFile.RESIZE);
        BoundingSphere bs = new BoundingSphere(new Point3d(0.0,0.0,0.0),Double.MAX_VALUE);
        String name;
        BranchGroup fishBranchGroup = new BranchGroup();
        TextureLoader t = new TextureLoader("source_folder//bg.jpg", myCanvas3D);
        Background fishBackground =  new Background(t.getImage());
        fishBackground.setImageScaleMode(Background.SCALE_FIT_ALL);

        Scene fishScene = null;
        try{
            fishScene = f.load("source_folder//Fish.obj");
        }
        catch (Exception e){
            System.out.println("File loading failed:" + e);
        }
        Hashtable roachNamedObjects = fishScene.getNamedObjects();
        Enumeration enumer = roachNamedObjects.keys();
        while (enumer.hasMoreElements()){
            name = (String) enumer.nextElement();
            System.out.println("Name: " + name);
        }

        // start animation
        Transform3D startTransformation = new Transform3D();
        startTransformation.setScale(2.0/6);
        Transform3D combinedStartTransformation = new Transform3D();
        combinedStartTransformation.mul(startTransformation);
        
        TransformGroup fishStartTransformGroup = new TransformGroup(combinedStartTransformation);
        TransformGroup sceneGroup = new TransformGroup();

        // moves
        int movesCount = 100; // moves count
        int movesDuration = 700; // moves for 0,3 seconds
        int startTime = 0; // launch animation after timeStart seconds

        TransformGroup bodyTG = new TransformGroup();
        TransformGroup headTG = new TransformGroup();
        TransformGroup tailTG = new TransformGroup();
        TransformGroup ven1TG = new TransformGroup();
        TransformGroup ven2TG = new TransformGroup();
        TransformGroup fin1TG = new TransformGroup();
        TransformGroup fin2TG = new TransformGroup();


        Shape3D ven = (Shape3D) roachNamedObjects.get("ventral_fin2");
        ven.setAppearance(getForParts());
        Shape3D ven2 = (Shape3D) roachNamedObjects.get("ventral_finq");
        ven2.setAppearance(getForParts());

        Shape3D eye = (Shape3D) roachNamedObjects.get("rt_eye");
        eye.setAppearance(getForEyes());

        Shape3D tail = (Shape3D) roachNamedObjects.get("tail");
        tail.setAppearance(getForParts());
        Shape3D body = (Shape3D) roachNamedObjects.get("rt_body");
        body.setAppearance(getForBody());

        Shape3D mouth = (Shape3D) roachNamedObjects.get("rt_mouth");
        mouth.setAppearance(getForParts());

        Shape3D head = (Shape3D) roachNamedObjects.get("head");
        head.setAppearance(getForBody());
        Shape3D fin2 = (Shape3D) roachNamedObjects.get("fin2");
        fin2.setAppearance(getForParts());
        Shape3D fin1 = (Shape3D) roachNamedObjects.get("fin1");
        fin1.setAppearance(getForParts());


        //body
        bodyTG.addChild(body.cloneTree());
        //tail
        tailTG.addChild(tail.cloneTree());
        Alpha tailAlpha = new Alpha(movesCount, Alpha.INCREASING_ENABLE, startTime, 0, 500,0,0,0,0,0);
        Transform3D tailRotAxis = new Transform3D();
        tailRotAxis.rotY(0);
        RotationInterpolator tailrot = new RotationInterpolator(tailAlpha, tailTG, tailRotAxis, (float) -Math.PI/18, (float) Math.PI/18); // Math.PI*2
        tailrot.setSchedulingBounds(bs);
        tailTG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tailTG.addChild(tailrot);

        //head
        headTG.addChild(head.cloneTree());
        headTG.addChild(mouth.cloneTree());
        headTG.addChild(eye.cloneTree());


        Alpha headAlpha = new Alpha(movesCount, Alpha.INCREASING_ENABLE, startTime, 0, 1000,0,0,0,0,0);
        Transform3D headRotAxis = new Transform3D();
        headRotAxis.rotZ(Math.PI/2);
        RotationInterpolator headrot = new RotationInterpolator(headAlpha, headTG, headRotAxis, (float) -Math.PI/30, (float) Math.PI/30); // Math.PI*2
        headrot.setSchedulingBounds(bs);
        headTG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        headTG.addChild(headrot);


        //ven1
        ven1TG.addChild(ven.cloneTree());
        Alpha ven1Alpha = new Alpha(movesCount, Alpha.INCREASING_ENABLE, startTime, 0, 300,0,0,0,0,0);
        Transform3D ven1RotAxis = new Transform3D();
        ven1RotAxis.rotY(-Math.PI/2);
        RotationInterpolator ven1rot = new RotationInterpolator(ven1Alpha, ven1TG, ven1RotAxis, (float) -Math.PI/6, (float) Math.PI/6); // Math.PI*2
        ven1rot.setSchedulingBounds(bs);
        ven1TG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        ven1TG.addChild(ven1rot);


        //ven2
        ven2TG.addChild(ven2.cloneTree());
        Alpha ven2Alpha = new Alpha(movesCount, Alpha.INCREASING_ENABLE, startTime, 0, 300,0,0,0,0,0);
        Transform3D ven2RotAxis = new Transform3D();
        ven2RotAxis.rotY(Math.PI/2);
        RotationInterpolator ven2rot = new RotationInterpolator(ven2Alpha, ven2TG, ven2RotAxis, (float) Math.PI/6, (float) -Math.PI/6); // Math.PI*2
        ven2rot.setSchedulingBounds(bs);
        ven2TG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        ven2TG.addChild(ven2rot);
        //fin2
        fin2TG.addChild(fin2.cloneTree());
        Alpha fin2Alpha = new Alpha(movesCount, Alpha.INCREASING_ENABLE, startTime, 0, 500,0,0,0,0,0);
        Transform3D fin2RotAxis = new Transform3D();
        fin2RotAxis.rotZ(Math.PI/2);
        RotationInterpolator fin2rot = new RotationInterpolator(fin2Alpha, fin2TG, fin2RotAxis, (float) Math.PI/10, (float) -Math.PI/10); // Math.PI*2
        fin2rot.setSchedulingBounds(bs);
        fin2TG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        fin2TG.addChild(fin2rot);

        //fin1
        fin1TG.addChild(fin1.cloneTree());
        Alpha fin1Alpha = new Alpha(movesCount, Alpha.INCREASING_ENABLE, startTime, 0, 500,0,0,0,0,0);
        Transform3D fin1RotAxis = new Transform3D();
        fin1RotAxis.rotZ(-Math.PI/2);
        RotationInterpolator fin1rot = new RotationInterpolator(fin1Alpha, fin1TG, fin1RotAxis, (float) -Math.PI/10, (float) Math.PI/10); // Math.PI*2
        fin1rot.setSchedulingBounds(bs);
        fin1TG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        fin1TG.addChild(fin1rot);

        sceneGroup.addChild(bodyTG);
        sceneGroup.addChild(headTG);
        sceneGroup.addChild(tailTG);
        sceneGroup.addChild(ven1TG);
        sceneGroup.addChild(ven2TG);
        sceneGroup.addChild(fin1TG);
        sceneGroup.addChild(fin2TG);


        Transform3D x = new Transform3D();
        x.rotY(-Math.PI/3);
        sceneGroup.setTransform(x);


        TransformGroup whiteTransXformGroup = translate(
                            fishStartTransformGroup,
                            new Vector3f(0.0f,0.0f,-0.7f));

        TransformGroup whiteRotXformGroup = rotate(whiteTransXformGroup, new Alpha(10,5000));
        fishStartTransformGroup.addChild(sceneGroup);
        fishBranchGroup.addChild(whiteRotXformGroup);


        BoundingSphere bounds = new BoundingSphere(new Point3d(120.0,250.0,100.0),Double.MAX_VALUE);
        fishBackground.setApplicationBounds(bounds);
        fishBranchGroup.addChild(fishBackground);

        fishBranchGroup.compile();
        su.addBranchGraph(fishBranchGroup);
    }

    public void addLight(SimpleUniverse su){
        BranchGroup bgLight = new BranchGroup();
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);
        Color3f lightColour1 = new Color3f(1.0f,1.0f,1.0f);
        Vector3f lightDir1 = new Vector3f(-1.0f,0.0f,-0.5f);
        DirectionalLight light1 = new DirectionalLight(lightColour1, lightDir1);
        light1.setInfluencingBounds(bounds);
        bgLight.addChild(light1);
        su.addBranchGraph(bgLight);
    }
    
    private TransformGroup translate(Node node, Vector3f vector){

        Transform3D transform3D = new Transform3D();
        transform3D.setTranslation(vector);
        TransformGroup transformGroup = 
                                     new TransformGroup();
        transformGroup.setTransform(transform3D);

        transformGroup.addChild(node);
        return transformGroup;
    }

    private TransformGroup rotate(Node node, Alpha alpha){
        TransformGroup xformGroup = new TransformGroup();
        xformGroup.setCapability(
                TransformGroup.ALLOW_TRANSFORM_WRITE);

        RotationInterpolator interpolator =
                new RotationInterpolator(alpha,xformGroup);

        interpolator.setSchedulingBounds(new BoundingSphere(
                new Point3d(0.0,0.0,0.0),1.0));

        xformGroup.addChild(interpolator);
        xformGroup.addChild(node);

        return xformGroup;
    }

    
    public static void main(String[] args) {
        Fish start = new Fish();
    }
    
}

