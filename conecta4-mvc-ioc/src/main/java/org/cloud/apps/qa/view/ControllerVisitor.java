package org.cloud.apps.qa.view;

import org.cloud.apps.qa.controller.PlayController;
import org.cloud.apps.qa.controller.ResumeController;
import org.cloud.apps.qa.controller.StartController;

public interface ControllerVisitor {

    void visit(StartController startController);
	void visit(PlayController playController);
	void visit(ResumeController resumeController);
    
}