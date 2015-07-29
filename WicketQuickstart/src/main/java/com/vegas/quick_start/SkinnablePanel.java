package com.vegas.quick_start;

import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.panel.Panel;

public class SkinnablePanel extends Panel {
    private String tagSkin;

    public SkinnablePanel(String id) {
        super(id);
    }

    @Override
    public String getVariation() {
        String superVariation = super.getVariation();

        determineTagSkin();

        if (tagSkin == null || tagSkin.length() == 0) {
            return superVariation;
        } else {
            return tagSkin;
        }
    }

    @Override
    public MarkupStream getAssociatedMarkupStream(boolean throwException) {
        // need to get the skin attribute from parent markup before we load our markup
        determineTagSkin();

        return super.getAssociatedMarkupStream(throwException);
    }

    private void determineTagSkin() {
        if (tagSkin == null) {
            tagSkin = getMarkupAttributes().getString("skin");
            if (tagSkin == null) {
                tagSkin = "";
            }
        }
    }
}
