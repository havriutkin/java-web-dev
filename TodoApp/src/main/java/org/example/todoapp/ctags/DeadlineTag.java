package org.example.todoapp.ctags;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;


public class DeadlineTag extends TagSupport {
    private Date deadline;

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public int doStartTag() throws JspException {
        if (deadline != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                pageContext.getOut().print("(Deadline: " + sdf.format(deadline) + ")");
            } catch (IOException e) {
                throw new JspException(e);
            }
        }
        return SKIP_BODY;
    }
}
