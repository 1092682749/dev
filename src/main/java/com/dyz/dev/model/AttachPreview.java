package com.dyz.dev.model;

import java.util.List;
import java.util.Map;

public class AttachPreview {
    List<String> initialPreviews;
    List<Map> initialPreviewConfigs;

    public List<String> getInitialPreviews() {
        return initialPreviews;
    }

    public void setInitialPreviews(List<String> initialPreviews) {
        this.initialPreviews = initialPreviews;
    }

    public List<Map> getInitialPreviewConfigs() {
        return initialPreviewConfigs;
    }

    public void setInitialPreviewConfigs(List<Map> initialPreviewConfigs) {
        this.initialPreviewConfigs = initialPreviewConfigs;
    }
}
