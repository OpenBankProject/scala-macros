package com.tesobe

import scala.annotation.StaticAnnotation

/**
  * Add this annotation to method or class constructor parameters
  * in order to exclude them from auto-generated cache keys.
  *
  * e.g.
  *
  * {{{
  * def foo(a: Int, @CacheKeyOmit b: String, c: String): Int = buildCacheKey { ... }
  * }}}
  *
  * will not include the value of the `b` parameter in its cache keys.
  */
final class CacheKeyOmit extends StaticAnnotation
