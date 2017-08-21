package proj.service.implementation.editor;

import proj.entity.User;
import proj.service.UserService;

import java.beans.PropertyEditorSupport;

/**
 * Created by SC on 19.02.2017.
 */
public class UserEditor extends PropertyEditorSupport {

    private  final UserService userService;

    public UserEditor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        User user = userService.findById(Integer.valueOf(text));
        super.setAsText(text);
    }
}
