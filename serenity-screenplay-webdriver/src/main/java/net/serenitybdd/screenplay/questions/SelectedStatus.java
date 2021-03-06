package net.serenitybdd.screenplay.questions;

import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;
import java.util.stream.Collectors;

public class SelectedStatus extends TargetedUIState<Boolean> {

    public SelectedStatus(Target target, Actor actor) {
        super(target, actor);
    }

    public static UIStateReaderBuilder<SelectedStatus> of(Target target) {
        return new UIStateReaderBuilder<>(target, SelectedStatus.class);
    }

    public Boolean resolve() {
        return target.resolveFor(actor).isSelected();
    }

    public List<Boolean> resolveAll() {
        return resolvedElements()
                .map(WebElementState::isSelected)
                .collect(Collectors.toList());
    }
}
