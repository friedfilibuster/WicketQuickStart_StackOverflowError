package com.vegas.quick_start;

import org.apache.wicket.markup.html.TransparentWebMarkupContainer;

public class TestPanel extends SkinnablePanel {
    public TestPanel(String id) {
        super(id);

        // purposefully not in markup
        add(new ChildPanel("child"));
        add(new TransparentWebMarkupContainer("trans"));
    }
}
