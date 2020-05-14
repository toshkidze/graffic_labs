package classes;


import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Book implements ActionListener {
    private TransformGroup carTransformGroup = new TransformGroup();
    private Transform3D carTransform3D = new Transform3D();
    private Timer timer;
    private float angle= -0.4f;
    public static void main(String[] args) {
        new Book();

    }

    private Book() {
        timer = new Timer(50, this);
        timer.start();
        BranchGroup scene = createSceneGraph();
        SimpleUniverse u = new SimpleUniverse();
        u.getViewingPlatform().setNominalViewingTransform();
        u.addBranchGraph(scene);

    }

    private BranchGroup createSceneGraph() {
        BranchGroup objRoot = new BranchGroup();
        carTransformGroup = new TransformGroup();
        carTransformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        MakePC();

        objRoot.addChild(carTransformGroup);

        Background background = new Background(new Color3f(1.0f, 1.0f, 1.0f));
        BoundingSphere sphere = new BoundingSphere(new Point3d(0,0,0), 100000);
        background.setApplicationBounds(sphere);
        objRoot.addChild(background);

        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),100.0);
        Color3f light1Color = new Color3f(1.0f, 0.5f, 0.4f);
        Vector3f light1Direction = new Vector3f(.8f, .8f, .0f);
        DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);
        light1.setInfluencingBounds(bounds);
        objRoot.addChild(light1);

        Color3f ambientColor = new Color3f(1.0f, 1.0f, 1.0f);
        AmbientLight ambientLightNode = new AmbientLight(ambientColor);
        ambientLightNode.setInfluencingBounds(bounds);
        objRoot.addChild(ambientLightNode);
        return objRoot;
    }

    private void MakePC() {
        Box cover_bot = BookBuilder.getCover(.25f,.3f,.01f);
        Transform3D body1T = new Transform3D();
        body1T.setTranslation(new Vector3f(.0f, .0f, .0f));
        TransformGroup body1TG = new TransformGroup();
        body1TG.setTransform(body1T);
        body1TG.addChild(cover_bot);
        carTransformGroup.addChild(body1TG);

        Box written = BookBuilder.getWritten(.248f,.29f,.03f);
        Transform3D body2T = new Transform3D();
        body2T.setTranslation(new Vector3f(-.002f, .0f, .038f));
        TransformGroup body2TG = new TransformGroup();
        body2TG.setTransform(body2T);
        body2TG.addChild(written);
        carTransformGroup.addChild(body2TG);

        Box cover_left = BookBuilder.getCover(.01f,.3f,.04f);
        Transform3D body3T = new Transform3D();
        body3T.setTranslation(new Vector3f(-.252f, .0f, .03f));
        TransformGroup body3TG = new TransformGroup();
        body3TG.setTransform(body3T);
        body3TG.addChild(cover_left);
        carTransformGroup.addChild(body3TG);

        Box cover_top = BookBuilder.getCover(.25f,.3f,.01f);
        Transform3D body4T = new Transform3D();
        body4T.rotY(Math.PI/3);
        body4T.setTranslation(new Vector3f(-.37f, .0f, .28f));
        TransformGroup body4TG = new TransformGroup();
        body4TG.setTransform(body4T);
        body4TG.addChild(cover_top);
        carTransformGroup.addChild(body4TG);

        Box bookEnd = BookBuilder.getBookEnd(.248f,.29f,.002f);
        Transform3D body5T = new Transform3D();
        body5T.rotY(Math.PI/3);
        body5T.setTranslation(new Vector3f(-.35f, .0f, .27f));
        TransformGroup body5TG = new TransformGroup();
        body5TG.setTransform(body5T);
        body5TG.addChild(bookEnd);
        carTransformGroup.addChild(body5TG);

        Box cover_right = BookBuilder.getSide(.001f,.29f,.031f);
        Transform3D body6T = new Transform3D();
        body6T.setTranslation(new Vector3f(.248f, .0f, .039f));
        TransformGroup body6TG = new TransformGroup();
        body6TG.setTransform(body6T);
        body6TG.addChild(cover_right);
        carTransformGroup.addChild(body6TG);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        carTransform3D.rotY(angle);
        carTransform3D.setScale(0.9);
        carTransformGroup.setTransform(carTransform3D);
        angle += 0.03;
    }
}
