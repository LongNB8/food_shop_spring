package com.example.food_shop_spring.Tags;

import lombok.SneakyThrows;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import javax.servlet.jsp.JspWriter;

public class SliderTags extends RequestContextAwareTag {

    @Override
    @SneakyThrows
    public void doFinally() {
        JspWriter writer = pageContext.getOut();
        try {

            writer.write("<section id=\"slider-area\">\n" +
                    "\t\t<div class=\"container\">\n" +
                    "\t\t\t<div class=\"row\">\n" +
                    "\t\t\t\t<div class=\"col-md-12\">\n" +
                    "\t\t\t\t\t<div id=\"slider\" class=\"nivoSlider\">\n" +
                    "\t\t\t\t    \t<img src='"+ pageContext.getServletContext().getContextPath() +"/resources/user/images/slider.jpg"+"' alt=\"\" style=\"width: 1120px; visibility: hidden;\">\n" +
                    "\t\t\t\t    \t<img src='"+ pageContext.getServletContext().getContextPath() +"/resources/user/images/slider1.jpg"+"' alt=\"\" style=\"width: 1120px; visibility: hidden;\">\n" +
                    "\t\t\t\t    \t<img src='"+ pageContext.getServletContext().getContextPath() +"/resources/user/images/slider2.jpg"+"' alt=\"\" style=\"width: 1120px; visibility: hidden;\">\n" +
                    "\t\t\t\t</div>\t<!-- End of /.col-md-12 -->\n" +
                    "\t\t\t</div>\t<!-- End of /.row -->\n" +
                    "\t\t</div>\t<!-- End of /.container -->\n" +
                    "\t</section>");

        } catch (Exception e){
            writer.write(e.getMessage());
        }
    }

    @Override
    protected int doStartTagInternal() throws Exception {
        return SKIP_BODY;
    }
}
