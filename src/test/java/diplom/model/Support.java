package diplom.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "url",
        "text"
})
@Getter
@Setter
public class Support {

    @JsonProperty("url")
    private String url;

    @JsonProperty("text")
    private String text;
}
