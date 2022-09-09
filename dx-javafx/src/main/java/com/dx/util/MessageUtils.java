package com.dx.util;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @ClassName MessageUtils
 * @function [message tips of system]
 * @Author lcz
 * @Date 2020/12/18 09:05
 */
@Slf4j
public class MessageUtils {

    /**
     * params means
     *
     * @param container     the show container
     * @param message       message tips
     * @param fadeInDelay   fadeInDelay
     * @param fadeOutDelay  fadeOutDelay
     * @param finishedEvent finishedEvent
     */
    public static void info(Pane container, String message, Integer fadeInDelay, Integer fadeOutDelay, EventHandler<ActionEvent> finishedEvent){
        try {
            /*default value*/
            loadMessage(container, message, fadeInDelay, fadeOutDelay, finishedEvent, "/fxml/message-info.fxml");
        } catch (IOException e) {
            e.printStackTrace();
            log.error("MessageUtils info load fxml error: {}", e.toString());
        }
    }

    public static void success(Pane container, String message, Integer fadeInDelay, Integer fadeOutDelay, EventHandler<ActionEvent> finishedEvent){
        try {
            /*default value*/
            loadMessage(container, message, fadeInDelay, fadeOutDelay, finishedEvent, "/fxml/message-success.fxml");
        } catch (IOException e) {
            e.printStackTrace();
            log.error("MessageUtils info load fxml error: {}", e.toString());
        }

    }

    public static void warning(Pane container, String message, Integer fadeInDelay, Integer fadeOutDelay, EventHandler<ActionEvent> finishedEvent){
        try {
            /*default value*/
            loadMessage(container, message, fadeInDelay, fadeOutDelay, finishedEvent, "/fxml/message-warn.fxml");
        } catch (IOException e) {
            e.printStackTrace();
            log.error("MessageUtils info load fxml error: {}", e.toString());
        }
    }

    public static void error(Pane container, String message, Integer fadeInDelay, Integer fadeOutDelay, EventHandler<ActionEvent> finishedEvent){
        try {
            loadMessage(container, message, fadeInDelay, fadeOutDelay, finishedEvent, "/fxml/message-error.fxml");
        } catch (IOException e) {
            e.printStackTrace();
            log.error("MessageUtils info load fxml error: {}", e.toString());
        }
    }

    private static void loadMessage(Pane container, String message, Integer fadeInDelay, Integer fadeOutDelay, EventHandler<ActionEvent> finishedEvent, String fxmlLocation) throws IOException {
        /*default value*/
        fadeInDelay = fadeInDelay != null ? fadeInDelay : 1000;
        fadeOutDelay = fadeOutDelay != null ? fadeOutDelay : 1000;
        finishedEvent = finishedEvent != null ? finishedEvent : defaultFinishedEvent();
        Region messageInfo = FXMLLoader.load(MessageUtils.class.getResource(fxmlLocation));
        messageInfo.setStyle("");
        ObservableList<Node> childrenUnmodifiable = messageInfo.getChildrenUnmodifiable();
        for (Node node : childrenUnmodifiable) {
            if ("messageArea".equals(node.getId())) {
                Text messageNode = (Text) ((TextFlow) node).getChildren().get(0);
                messageNode.setText(message);
            }
        }
        container.getChildren().add(messageInfo);
//        Pane.setAlignment(messageInfo, Pos.TOP_CENTER);
        fade(messageInfo, fadeInDelay, fadeOutDelay, finishedEvent);
    }

    public static void fade(Node node, int fadeInDelay, int fadeOutDelay, EventHandler<ActionEvent> finishedEvent) {

        Timeline fadeInTimeline = new Timeline();

        final KeyValue fadeInKey = new KeyValue(node.opacityProperty(), node.opacityProperty().doubleValue());
        KeyFrame fadeIn = new KeyFrame(Duration.millis(fadeInDelay), fadeInKey);
        fadeInTimeline.getKeyFrames().add(fadeIn);

        fadeInTimeline.setOnFinished((ae) -> {
            Timeline fadeOutTimeline = new Timeline();
            final KeyValue fadeOutKey = new KeyValue(node.opacityProperty(), 0);
            KeyFrame fadeOut = new KeyFrame(Duration.millis(fadeOutDelay), fadeOutKey);
            fadeOutTimeline.getKeyFrames().add(fadeOut);
            fadeOutTimeline.setOnFinished(finishedEvent);

            node.setOnMouseEntered(event -> fadeOutTimeline.pause());
            node.setOnMouseExited(event -> fadeOutTimeline.play());
            fadeOutTimeline.playFromStart();
        });

        node.setOnMouseEntered(event -> fadeInTimeline.pause());
        node.setOnMouseExited(event -> fadeInTimeline.play());
        fadeInTimeline.playFromStart();
    }

    public static EventHandler<ActionEvent> defaultFinishedEvent() {
        return (EventHandler) event -> log.info("defaultFinishedEvent log info...");
    }
}
