package sample.environment.base;

import sample.environment.geometry.euclide.Point;

/**
 * A function is a process or a relation that associates each element x of a set X, the domain of the function,
 * to a single element y of another set Y (possibly the same set), the codomain of the function.
 *
 * If the function is called f, this relation is denoted y = f (x) (read f of x), the element x is the argument
 * or input of the function, and y is the value of the function, the output, or the image of x by f.
 *
 * x ↦ f (x)
 */
public abstract class Function {

    public abstract float getImage(float fiber);

}
