import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;
public class Fish_lab3 extends Application {

        public static void main(String args[]) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) {
            Group root = new Group();
            int x = 3;
            Scene scene = new Scene(root, 1000, 600);

            Path tail1 = new Path();
            tail1.setFill(Color.rgb(207,88,41));
            tail1.setStrokeWidth(4);
            tail1.getElements().addAll(
                    new MoveTo(133, 80),
                    new QuadCurveTo(146,57, 146,44),
                    new ArcTo(4, 4, 0, 152, 42, false, true),
                    new QuadCurveTo(206,58, 233,88)
            );
            root.getChildren().add(tail1);

            QuadCurve tail1_line = new QuadCurve(145,74,153,58,152,42);
            tail1_line.setStrokeWidth(1);

            QuadCurve tail1_line2 = new QuadCurve(154,73,160,57,157,45);
            tail1_line2.setStrokeWidth(1);

            QuadCurve tail1_line3 = new QuadCurve(163,71,168,57,165,46);
            tail1_line3.setStrokeWidth(1);

            QuadCurve tail1_line4 = new QuadCurve(170,71,174,59,172,48);
            tail1_line4.setStrokeWidth(1);

            QuadCurve tail1_line5 = new QuadCurve(177,70,181,60,179,49);
            tail1_line5.setStrokeWidth(1);

            QuadCurve tail1_line6 = new QuadCurve(186,71,189,62,186,52);
            tail1_line6.setStrokeWidth(1);

            QuadCurve tail1_line7 = new QuadCurve(192,73,196,65,194,57);
            tail1_line7.setStrokeWidth(1);

            QuadCurve tail1_line8 = new QuadCurve(200,74,203,67,202,61);
            tail1_line8.setStrokeWidth(1);

            QuadCurve tail1_line9 = new QuadCurve(207,76,210,71,207,64);
            tail1_line9.setStrokeWidth(1);

            QuadCurve tail1_line10 = new QuadCurve(214,77,215,75,214,69);
            tail1_line10.setStrokeWidth(1);

            QuadCurve tail1_line11 = new QuadCurve(218,80,221,77,218,73);
            tail1_line11.setStrokeWidth(1);

            root.getChildren().addAll(tail1_line,tail1_line2,tail1_line3,tail1_line4,tail1_line5,
                    tail1_line6,tail1_line7,tail1_line8,tail1_line9,tail1_line10,tail1_line11);

            Path p = new Path();
            p.setStrokeWidth(4);
            p.setStroke(Color.BLACK);
            p.setFill(Color.rgb(235,201,15));
            p.getElements().add(new MoveTo(60, 190));
            p.getElements().add(new QuadCurveTo(43,186, 43, 173));
            p.getElements().add(new QuadCurveTo(49,166, 43, 161));
            p.getElements().add(new ArcTo(5, 7, 0, 47, 150, false, true));
            p.getElements().add(new LineTo(60,150));
            p.getElements().add(new CubicCurveTo(68,126,93,94, 111, 87));
            p.getElements().add(new CubicCurveTo(158,70,189,72, 233, 88));
            p.getElements().add(new ArcTo(20, 20, 0, 240, 94, false, true));
            p.getElements().add(new QuadCurveTo(249,105, 274, 151));
            p.getElements().add(new LineTo(271, 149));
            p.getElements().add(new ArcTo(85, 65, 0, 60, 190, false, true));
            root.getChildren().add(p);

            Path neck = new Path();
            neck.setFill(Color.rgb(235,201,15));
            neck.setStrokeWidth(2);
            neck.getStrokeDashArray().addAll(4d);
            neck.setStrokeDashOffset(45);
            neck.setStroke(Color.WHITE);
            neck.getElements().addAll(
                    new MoveTo(119, 85),
                    new CubicCurveTo(142,145, 141, 189, 120, 243)
            );
            root.getChildren().add(neck);

            Path tail2 = new Path();
            tail2.setFill(Color.rgb(207,88,41));
            tail2.setStrokeWidth(4);
            tail2.getElements().addAll(
                    new MoveTo(289, 234),
                    new QuadCurveTo(280,212, 267,194),
                    new ArcTo(10, 10, 0, 258, 177, false, true),
                    new ArcTo(10, 10, 0, 259, 158, false, true),
                    new ArcTo(10, 10, 0, 268, 140, false, true),
                    new CubicCurveTo(277,147,287,142, 290, 133),
                    new ArcTo(3, 5, 15, 310, 126, false, true),
                    new CubicCurveTo(315,154,307,163, 304, 168),
                    new CubicCurveTo(298,173, 298, 182, 304, 190),
                    new CubicCurveTo(311,201, 309, 220, 300, 230),
                    new ArcTo(6, 10, 30, 290, 235, false, true)
            );
            root.getChildren().add(tail2);

            CubicCurve tail2_line = new CubicCurve(266,151,280,153,295,148,306,137);
            CubicCurve tail2_line2 = new CubicCurve(266,157,279,158,293,155,306,150);
            CubicCurve tail2_line3 = new CubicCurve(266,164,278,165,291,164,303,160);
            CubicCurve tail2_line4 = new CubicCurve(266,171,278,170,289,170,299,170);
            CubicCurve tail2_line5 = new CubicCurve(266,174,277,174,288,177,297,179);
            CubicCurve tail2_line6 = new CubicCurve(267,178,282,181,291,187,302,196);
            CubicCurve tail2_line7 = new CubicCurve(268,184,282,188,292,194,303,207);
            CubicCurve tail2_line8 = new CubicCurve(268,189,281,194,292,205,301,217);
            CubicCurve tail2_line9 = new CubicCurve(269,193,280,201,287,212,295,224);
            tail2_line.setStrokeWidth(2);
            tail2_line2.setStrokeWidth(2);
            tail2_line3.setStrokeWidth(2);
            tail2_line4.setStrokeWidth(2);
            tail2_line5.setStrokeWidth(2);
            tail2_line6.setStrokeWidth(2);
            tail2_line7.setStrokeWidth(2);
            tail2_line8.setStrokeWidth(2);
            tail2_line9.setStrokeWidth(2);
            root.getChildren().addAll(tail2_line,tail2_line2,tail2_line3,tail2_line4,tail2_line5,tail2_line6,tail2_line7,tail2_line8,tail2_line9);


            Path tail3 = new Path();
            tail3.setFill(Color.rgb(207,88,41));
            tail3.setStrokeWidth(4);
            tail3.getElements().addAll(
                    new MoveTo(168, 283),
                    new QuadCurveTo(143,251, 141,216),
                    new ArcTo(10, 10, 30, 158, 213, false, true),
                    new QuadCurveTo(186,243, 204,255),
                    new ArcTo(10, 10, 30, 206, 272, false, true),
                    new CubicCurveTo(193,282, 172, 284, 170, 284)
                    );
            root.getChildren().add(tail3);

            QuadCurve tail3_line = new QuadCurve(153,217,177,244,202,261);
            QuadCurve tail3_line2 = new QuadCurve(154,230,174,251,200,269);
            QuadCurve tail3_line3 = new QuadCurve(156,238,171,257,193,275);
            QuadCurve tail3_line4 = new QuadCurve(155,245,168,263,187,280);
            QuadCurve tail3_line5 = new QuadCurve(152,250,162,267,176,281);

            root.getChildren().addAll(tail3_line,tail3_line2,tail3_line3,tail3_line4,tail3_line5);


            Circle eye = new Circle(96,136,13.5,Color.WHITE);
            eye.setStrokeWidth(2);
            eye.setStroke(Color.BLACK);
            root.getChildren().add(eye);

            Circle eye_centre = new Circle(96,144,6,Color.BLACK);
            eye_centre.setStrokeWidth(2);
            eye_centre.setStroke(Color.BLACK);
            root.getChildren().add(eye_centre);

            Line eye_line1 = new Line(105,147,120,142);
            eye_line1.setStrokeWidth(1);
            Line eye_line2 = new Line(104,148,120,146);
            eye_line2.setStrokeWidth(1);
            Line eye_line3 = new Line(86,128,85,122);
            eye_line3.setStrokeWidth(1);
            Line eye_line4 = new Line(92,124,92,119);
            eye_line4.setStrokeWidth(1);
            Line eye_line5 = new Line(96,123,96,118);
            eye_line5.setStrokeWidth(1);
            Line eye_line6 = new Line(100,124,100,119);
            eye_line6.setStrokeWidth(1);
            Line eye_line7 = new Line(105,126,105,120);
            eye_line7.setStrokeWidth(1);
            Line eye_line8 = new Line(108,130,108,121);
            eye_line8.setStrokeWidth(1);

            QuadCurve eye_brows = new QuadCurve(91,112,98,108,109,115);
            eye_brows.setStrokeWidth(2);

            root.getChildren().addAll(eye_line1,eye_line2,eye_line3,eye_line4,eye_line5,eye_line6,eye_line7,eye_line8,eye_brows);



            Path blue_spot = new Path();
            blue_spot.setFill(Color.rgb(129,118,185));
            blue_spot.setStrokeWidth(0);
            blue_spot.getElements().addAll(
                    new MoveTo(149, 120),
                    new QuadCurveTo(145,106, 139, 91),
                    new ArcTo(15, 10, 0, 149, 120, false, true)
            );
            root.getChildren().add(blue_spot);


            Path blue_spot2 = new Path();
            blue_spot2.setFill(Color.rgb(129,118,185));
            blue_spot2.setStrokeWidth(0);
            blue_spot2.getElements().addAll(
                    new MoveTo(153, 159),
                    new QuadCurveTo(148,145, 149, 131),
                    new ArcTo(15, 10, 0, 153, 159, false, true)
            );
            root.getChildren().add(blue_spot2);


            Path blue_spot3 = new Path();
            blue_spot3.setFill(Color.rgb(129,118,185));
            blue_spot3.setStrokeWidth(0);
            blue_spot3.getElements().addAll(
                    new MoveTo(150, 199),
                    new QuadCurveTo(153,183, 151, 169),
                    new ArcTo(15, 10, 0, 150, 199, false, true)
            );
            root.getChildren().add(blue_spot3);


            Path green_spot = new Path();
            green_spot.setFill(Color.rgb(63,183,112));
            green_spot.setStrokeWidth(0);
            green_spot.getElements().addAll(
                    new MoveTo(183, 224),
                    new QuadCurveTo(180,214, 171, 209),
                    new QuadCurveTo(182,204, 185, 195),
                    new ArcTo(15, 10, 0, 183, 224, false, true)
            );
            root.getChildren().add(green_spot);

            Path green_spot2 = new Path();
            green_spot2.setFill(Color.rgb(63,183,112));
            green_spot2.setStrokeWidth(0);
            green_spot2.getElements().addAll(
                    new MoveTo(188, 180),
                    new QuadCurveTo(184,169, 173, 164),
                    new QuadCurveTo(184,156, 186, 146),
                    new ArcTo(13, 10, 0, 188, 180, false, true)
            );
            root.getChildren().add(green_spot2);

            Path green_spot3 = new Path();
            green_spot3.setFill(Color.rgb(63,183,112));
            green_spot3.setStrokeWidth(0);
            green_spot3.getElements().addAll(
                    new MoveTo(182, 135),
                    new QuadCurveTo(179,126, 170, 123),
                    new QuadCurveTo(178,113, 179, 101),
                    new ArcTo(12, 10, 0, 182, 135, false, true)
            );
            root.getChildren().add(green_spot3);

            Path red_spot = new Path();
            red_spot.setFill(Color.rgb(251,105,119));
            red_spot.setStrokeWidth(0);
            red_spot.getElements().addAll(
                    new MoveTo(214, 205),
                    new QuadCurveTo(211,193, 203, 188),
                    new QuadCurveTo(212,182, 218, 173),
                    new ArcTo(12, 10, 0, 214, 205, false, true)
            );
            root.getChildren().add(red_spot);

            Path red_spot2 = new Path();
            red_spot2.setFill(Color.rgb(251,105,119));
            red_spot2.setStrokeWidth(0);
            red_spot2.getElements().addAll(
                    new MoveTo(215, 159),
                    new QuadCurveTo(211,148, 200, 141),
                    new QuadCurveTo(212,133, 218, 124),
                    new ArcTo(11, 10, 0, 215, 159, false, true)
            );
            root.getChildren().add(red_spot2);




            CubicCurve in_spot_curve = new CubicCurve(151,118,170,107,165,93,142,93);
            in_spot_curve.setFill(Color.rgb(129,118,185));
            in_spot_curve.getStrokeDashArray().addAll(3d);
            in_spot_curve.setStroke(Color.WHITE);

            CubicCurve in_spot_curve2 = new CubicCurve(154,157,172,155,174,136,151,133);
            in_spot_curve2.setFill(Color.rgb(129,118,185));
            in_spot_curve2.getStrokeDashArray().addAll(3d);
            in_spot_curve2.setStroke(Color.WHITE);

            CubicCurve in_spot_curve3 = new CubicCurve(153,196,173,191,172,176,155,170);
            in_spot_curve3.setFill(Color.rgb(129,118,185));
            in_spot_curve3.getStrokeDashArray().addAll(3d);
            in_spot_curve3.setStroke(Color.WHITE);

            CubicCurve in_spot_curve4 = new CubicCurve(183,132,199,129,201,111,183,103);
            in_spot_curve4.setFill(Color.rgb(63,183,112));
            in_spot_curve4.getStrokeDashArray().addAll(3d);
            in_spot_curve4.setStroke(Color.WHITE);

            CubicCurve in_spot_curve5 = new CubicCurve(189,176,209,169,207,156,190,148);
            in_spot_curve5.setFill(Color.rgb(63,183,112));
            in_spot_curve5.getStrokeDashArray().addAll(3d);
            in_spot_curve5.setStroke(Color.WHITE);

            CubicCurve in_spot_curve6 = new CubicCurve(186,222,204,217,204,202,189,197);
            in_spot_curve6.setFill(Color.rgb(63,183,112));
            in_spot_curve6.getStrokeDashArray().addAll(3d);
            in_spot_curve6.setStroke(Color.WHITE);

            CubicCurve in_spot_curve7 = new CubicCurve(217,154,231,151,233,135,221,127);
            in_spot_curve7.setFill(Color.rgb(251,105,119));
            in_spot_curve7.getStrokeDashArray().addAll(3d);
            in_spot_curve7.setStroke(Color.WHITE);

            CubicCurve in_spot_curve8 = new CubicCurve(217,202,233,197,236,182,220,175);
            in_spot_curve8.setFill(Color.rgb(251,105,119));
            in_spot_curve8.getStrokeDashArray().addAll(3d);
            in_spot_curve8.setStroke(Color.WHITE);

            root.getChildren().addAll(in_spot_curve,in_spot_curve2,in_spot_curve3,in_spot_curve4,in_spot_curve5,in_spot_curve6, in_spot_curve7,in_spot_curve8);

            Circle in_spot = new Circle(153,103,3,Color.WHITE);
            Circle in_spot2 = new Circle(160,145,3,Color.WHITE);
            Circle in_spot3 = new Circle(160,183,3,Color.WHITE);
            Circle in_spot4 = new Circle(188,117,3,Color.WHITE);
            Circle in_spot5 = new Circle(194,161,3,Color.WHITE);
            Circle in_spot6 = new Circle(192,209,3,Color.WHITE);
            Circle in_spot7 = new Circle(220,140,3,Color.WHITE);
            Circle in_spot8 = new Circle(222,188,3,Color.WHITE);

            root.getChildren().addAll(in_spot,in_spot2,in_spot3,in_spot4,in_spot5,in_spot6,in_spot7,in_spot8);

            int cycleCount = 2;
            int time = 2000;

            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(time), root);
            scaleTransition.setToX(2);
            scaleTransition.setToY(2);
            scaleTransition.setAutoReverse(true);

            RotateTransition rotateTransition = new RotateTransition(Duration.millis(time), root);
            rotateTransition.setByAngle(360f);
            rotateTransition.setCycleCount(cycleCount);
            rotateTransition.setAutoReverse(true);

            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(time), root);
            translateTransition.setFromX(400);
            translateTransition.setFromY(400);
            translateTransition.setToX(0);
            translateTransition.setToY(0);
            translateTransition.setCycleCount(cycleCount + 1);
            translateTransition.setAutoReverse(true);

            TranslateTransition translateTransition2 = new TranslateTransition(Duration.millis(time), root);
            translateTransition2.setFromX(0);
            translateTransition2.setToX(400);
            translateTransition.setFromY(0);
            translateTransition.setToY(400);
            translateTransition2.setCycleCount(cycleCount + 1);
            translateTransition2.setAutoReverse(true);

            ScaleTransition scaleTransition2 = new ScaleTransition(Duration.millis(time), root);
            scaleTransition2.setToX(0.1);
            scaleTransition2.setToY(0.1);
            scaleTransition2.setCycleCount(cycleCount);
            scaleTransition2.setAutoReverse(true);

            ParallelTransition parallelTransition = new ParallelTransition();
            parallelTransition.getChildren().

                    addAll(
                            rotateTransition,
                            scaleTransition,
                            scaleTransition2,
                            translateTransition
                    );
            parallelTransition.setCycleCount(Timeline.INDEFINITE);
            parallelTransition.play();

            primaryStage.setTitle("Lab 3");
            primaryStage.setScene(scene);
            primaryStage.show();
        }

}
