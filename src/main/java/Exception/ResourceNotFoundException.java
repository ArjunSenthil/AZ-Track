package Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class ResourceNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	private Long resourceId;
	public ResourceNotFoundException(Long resourceId,String message) 
	{
		super(message);
        this.setResourceId(resourceId);

	}

	public Long getResourceId() {
		return resourceId;
	}
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
}
