package annotationsTracker;

public @interface Uniqueness {
  Constraints constraints()
    default @Constraints(unique=true);
}
