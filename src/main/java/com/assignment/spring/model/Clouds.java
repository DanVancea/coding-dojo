
package com.assignment.spring.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author D.Vancea
 *
 * weird representation of clouds but ok..
 * it could be an Enum because you only got certain cloud types
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public enum Clouds {

    CLEAR_SKY,
    CIRRUS,
    CIRROCUMULUS,
    CIRROSTRATUS,
    ALTOCUMULUS,
    ALTOSTRATUS,
    NIMBOSTRATUS,
    STRATOCUMULUS,
    STRATUS,
    CUMULUS,
    CUMULONIMBUS;

    }


