/**
 * 
 */
package tw.com.iisi.fgs.commons.util;

/**
 * @author EustaceHsieh
 *
 */
public interface IResult<E> extends IMessage, IHeader {

    void setResult(E result);

}
