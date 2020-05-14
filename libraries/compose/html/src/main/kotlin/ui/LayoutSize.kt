/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ui

/**
 * Declare the preferred width of the content to be exactly [width]dp. The incoming measurement
 * [Constraints] may override this value, forcing the content to be either smaller or larger.
 *
 * See [preferredHeight] or [preferredSize] to set other preferred dimensions.
 * See [preferredWidthIn], [preferredHeightIn] or [preferredSizeIn] to set a preferred size range.
 *
 * Example usage:
 * @sample androidx.ui.layout.samples.SimplePreferredWidthModifier
 */
fun Modifier.preferredWidth(width: Dp) = preferredSizeIn(minWidth = width, maxWidth = width)

/**
 * Declare the preferred height of the content to be exactly [height]dp. The incoming measurement
 * [Constraints] may override this value, forcing the content to be either smaller or larger.
 *
 * See [preferredWidth] or [preferredSize] to set other preferred dimensions.
 * See [preferredWidthIn], [preferredHeightIn] or [preferredSizeIn] to set a preferred size range.
 *
 * Example usage:
 * @sample androidx.ui.layout.samples.SimplePreferredHeightModifier
 */
fun Modifier.preferredHeight(height: Dp) = preferredSizeIn(minHeight = height, maxHeight = height)

/**
 * Declare the preferred size of the content to be exactly [size]dp square. The incoming measurement
 * [Constraints] may override this value, forcing the content to be either smaller or larger.
 *
 * See [preferredWidth] or [preferredHeight] to set width or height alone.
 * See [preferredWidthIn], [preferredHeightIn] or [preferredSizeIn] to set a preferred size range.
 *
 * Example usage:
 * @sample androidx.ui.layout.samples.SimplePreferredSizeModifier
 */
fun Modifier.preferredSize(size: Dp) = preferredSizeIn(size, size, size, size)

/**
 * Declare the preferred size of the content to be exactly [width]dp by [height]dp. The incoming
 * measurement [Constraints] may override this value, forcing the content to be either smaller or
 * larger.
 *
 * See [preferredWidth] or [preferredHeight] to set width or height alone.
 * See [preferredWidthIn], [preferredHeightIn] or [preferredSizeIn] to set a preferred size range.
 *
 * Example usage:
 * @sample androidx.ui.layout.samples.SimplePreferredSizeModifier
 */
fun Modifier.preferredSize(width: Dp, height: Dp) = preferredSizeIn(
    minWidth = width,
    maxWidth = width,
    minHeight = height,
    maxHeight = height
)

/**
 * Constrain the width of the content to be between [minWidth]dp and [maxWidth]dp as permitted
 * by the incoming measurement [Constraints]. If the incoming constraints are more restrictive
 * the requested size will obey the incoming constraints and attempt to be as close as possible
 * to the preferred size.
 */
fun Modifier.preferredWidthIn(
    minWidth: Dp = Dp.Unspecified,
    maxWidth: Dp = Dp.Unspecified
) = preferredSizeIn(minWidth = minWidth, maxWidth = maxWidth)

/**
 * Constrain the height of the content to be between [minHeight]dp and [maxHeight]dp as permitted
 * by the incoming measurement [Constraints]. If the incoming constraints are more restrictive
 * the requested size will obey the incoming constraints and attempt to be as close as possible
 * to the preferred size.
 */
fun Modifier.preferredHeightIn(
    minHeight: Dp = Dp.Unspecified,
    maxHeight: Dp = Dp.Unspecified
) = preferredSizeIn(minHeight = minHeight, maxHeight = maxHeight)

/**
 * Constrain the size of the content to be within [constraints] as permitted by the incoming
 * measurement [Constraints]. If the incoming measurement constraints are more restrictive the
 * requested size will obey the incoming constraints and attempt to be as close as possible to
 * the preferred size.
 */
fun Modifier.preferredSizeIn(constraints: DpConstraints) = preferredSizeIn(
    constraints.minWidth,
    constraints.minHeight,
    constraints.maxWidth,
    constraints.maxHeight
)

/**
 * Constrain the width of the content to be between [minWidth]dp and [maxWidth]dp and the height
 * of the content to be between [minHeight] and [maxHeight] as permitted by the incoming
 * measurement [Constraints]. If the incoming constraints are more restrictive the requested size
 * will obey the incoming constraints and attempt to be as close as possible to the preferred size.
 */
fun Modifier.preferredSizeIn(
    minWidth: Dp = Dp.Unspecified,
    minHeight: Dp = Dp.Unspecified,
    maxWidth: Dp = Dp.Unspecified,
    maxHeight: Dp = Dp.Unspecified
) = this + SizeModifier(minWidth, minHeight, maxWidth, maxHeight, true)

/**
 * Declare the width of the content to be exactly [width]dp. The incoming measurement
 * [Constraints] will not override this value. If the content chooses a size that does not
 * satisfy the incoming [Constraints], the parent layout will be reported a size coerced
 * in the [Constraints], and the position of the content will be automatically offset to be
 * centered on the space assigned to the child by the parent layout under the assumption that
 * [Constraints] were respected.
 *
 * See [widthIn] and [sizeIn] to set a size range.
 * See [preferredWidth] to set a preferred width, which is only respected when the incoming
 * constraints allow it.
 *
 * Example usage:
 * @sample androidx.ui.layout.samples.SimpleWidthModifier
 */
fun Modifier.width(width: Dp) = sizeIn(minWidth = width, maxWidth = width)

/**
 * Declare the height of the content to be exactly [height]dp. The incoming measurement
 * [Constraints] will not override this value. If the content chooses a size that does not
 * satisfy the incoming [Constraints], the parent layout will be reported a size coerced
 * in the [Constraints], and the position of the content will be automatically offset to be
 * centered on the space assigned to the child by the parent layout under the assumption that
 * [Constraints] were respected.
 *
 * See [heightIn] and [sizeIn] to set a size range.
 * See [preferredHeight] to set a preferred height, which is only respected when the incoming
 * constraints allow it.
 *
 * Example usage:
 * @sample androidx.ui.layout.samples.SimpleHeightModifier
 */
fun Modifier.height(height: Dp) = sizeIn(minHeight = height, maxHeight = height)

/**
 * Declare the size of the content to be exactly [size]dp width and height. The incoming measurement
 * [Constraints] will not override this value. If the content chooses a size that does not
 * satisfy the incoming [Constraints], the parent layout will be reported a size coerced
 * in the [Constraints], and the position of the content will be automatically offset to be
 * centered on the space assigned to the child by the parent layout under the assumption that
 * [Constraints] were respected.
 *
 * See [sizeIn] to set a size range.
 * See [preferredSize] to set a preferred size, which is only respected when the incoming
 * constraints allow it.
 *
 * Example usage:
 * @sample androidx.ui.layout.samples.SimpleSizeModifier
 */
fun Modifier.size(size: Dp) = sizeIn(size, size, size, size)

/**
 * Declare the size of the content to be exactly [width]dp and [height]dp. The incoming measurement
 * [Constraints] will not override this value. If the content chooses a size that does not
 * satisfy the incoming [Constraints], the parent layout will be reported a size coerced
 * in the [Constraints], and the position of the content will be automatically offset to be
 * centered on the space assigned to the child by the parent layout under the assumption that
 * [Constraints] were respected.
 *
 * See [sizeIn] to set a size range.
 * See [preferredSize] to set a preferred size, which is only respected when the incoming
 * constraints allow it.
 *
 * Example usage:
 * @sample androidx.ui.layout.samples.SimpleWidthModifier
 */
fun Modifier.size(width: Dp, height: Dp) = sizeIn(
    minWidth = width,
    maxWidth = width,
    minHeight = height,
    maxHeight = height
)

/**
 * Constrain the width of the content to be between [minWidth]dp and [maxWidth]dp.
 * If the content chooses a size that does not satisfy the incoming [Constraints], the
 * parent layout will be reported a size coerced in the [Constraints], and the position
 * of the content will be automatically offset to be centered on the space assigned to
 * the child by the parent layout under the assumption that [Constraints] were respected.
 */
fun Modifier.widthIn(
    minWidth: Dp = Dp.Unspecified,
    maxWidth: Dp = Dp.Unspecified
) = sizeIn(minWidth = minWidth, maxWidth = maxWidth)

/**
 * Constrain the height of the content to be between [minHeight]dp and [maxHeight]dp.
 * If the content chooses a size that does not satisfy the incoming [Constraints], the
 * parent layout will be reported a size coerced in the [Constraints], and the position
 * of the content will be automatically offset to be centered on the space assigned to
 * the child by the parent layout under the assumption that [Constraints] were respected.
 */
fun Modifier.heightIn(
    minHeight: Dp = Dp.Unspecified,
    maxHeight: Dp = Dp.Unspecified
) = sizeIn(minHeight = minHeight, maxHeight = maxHeight)

/**
 * Constrain the size of the content to be within [constraints].
 * If the content chooses a size that does not satisfy the incoming [Constraints], the
 * parent layout will be reported a size coerced in the [Constraints], and the position
 * of the content will be automatically offset to be centered on the space assigned to
 * the child by the parent layout under the assumption that [Constraints] were respected.
 */
fun Modifier.sizeIn(constraints: DpConstraints) = sizeIn(
    constraints.minWidth,
    constraints.minHeight,
    constraints.maxWidth,
    constraints.maxHeight
)

/**
 * Constrain the width of the content to be between [minWidth]dp and [maxWidth]dp, and the
 * height of the content to be between [minHeight]dp and [maxHeight]dp.
 * If the content chooses a size that does not satisfy the incoming [Constraints], the
 * parent layout will be reported a size coerced in the [Constraints], and the position
 * of the content will be automatically offset to be centered on the space assigned to
 * the child by the parent layout under the assumption that [Constraints] were respected.
 */
fun Modifier.sizeIn(
    minWidth: Dp = Dp.Unspecified,
    minHeight: Dp = Dp.Unspecified,
    maxWidth: Dp = Dp.Unspecified,
    maxHeight: Dp = Dp.Unspecified
) = this + SizeModifier(minWidth, minHeight, maxWidth, maxHeight, false)

/**
 * Have the content fill the [Constraints.maxWidth] of the incoming measurement constraints
 * by setting the [minimum width][Constraints.minWidth] to be equal to the
 * [maximum width][Constraints.maxWidth]. If the incoming maximum width is [IntPx.Infinity] this
 * modifier will have no effect.
 *
 * Example usage:
 * @sample androidx.ui.layout.samples.SimpleFillWidthModifier
 */
fun Modifier.fillMaxWidth() = this + FillModifier(Direction.Horizontal)

/**
 * Have the content fill the [Constraints.maxHeight] of the incoming measurement constraints
 * by setting the [minimum height][Constraints.minHeight] to be equal to the
 * [maximum height][Constraints.maxHeight]. If the incoming maximum height is [IntPx.Infinity] this
 * modifier will have no effect.
 *
 * Example usage:
 * @sample androidx.ui.layout.samples.SimpleFillHeightModifier
 */
fun Modifier.fillMaxHeight() = this + FillModifier(Direction.Vertical)

/**
 * Have the content fill the [Constraints.maxWidth] and [Constraints.maxHeight] of the incoming
 * measurement constraints by setting the [minimum width][Constraints.minWidth] to be equal to the
 * [maximum width][Constraints.maxWidth] and the [minimum height][Constraints.minHeight] to be
 * equal to the [maximum height][Constraints.maxHeight]. If the incoming maximum width or height
 * is [IntPx.Infinity] this modifier will have no effect in that dimension.
 *
 * Example usage:
 * @sample androidx.ui.layout.samples.SimpleFillModifier
 */
fun Modifier.fillMaxSize() = this + FillModifier(Direction.Both)

/**
 * Allow the content to measure at its desired width without regard for the incoming measurement
 * [minimum width constraint][Constraints.minWidth]. If the content's measured size is smaller
 * than the minimum width constraint, [align] it within that minimum width space.
 *
 * Example usage:
 * @sample androidx.ui.layout.samples.SimpleWrapContentHorizontallyAlignedModifier
 */
// TODO(popam): avoid recreating modifier for common align
fun Modifier.wrapContentWidth(align: Alignment.Horizontal = Alignment.CenterHorizontally) =
    this + AlignmentModifier(Alignment(-1f, align.bias), Direction.Horizontal)

/**
 * Allow the content to measure at its desired height without regard for the incoming measurement
 * [minimum height constraint][Constraints.minHeight]. If the content's measured size is smaller
 * than the minimum height constraint, [align] it within that minimum height space.
 *
 * Example usage:
 * @sample androidx.ui.layout.samples.SimpleWrapContentVerticallyAlignedModifier
 */
// TODO(popam): avoid recreating modifier for common align
fun Modifier.wrapContentHeight(align: Alignment.Vertical = Alignment.CenterVertically) =
    this + AlignmentModifier(Alignment(align.bias, -1f), Direction.Vertical)

/**
 * Allow the content to measure at its desired size without regard for the incoming measurement
 * [minimum width][Constraints.minWidth] or [minimum height][Constraints.minHeight] constraints.
 * If the content's measured size is smaller than the minimum size constraint, [align] it
 * within that minimum sized space.
 *
 * Example usage:
 * @sample androidx.ui.layout.samples.SimpleWrapContentAlignedModifier
 */
fun Modifier.wrapContentSize(align: Alignment = Alignment.Center) =
    this + AlignmentModifier(align, Direction.Both)

/**
 * Constrain the size of the wrapped layout only when it would be otherwise unconstrained:
 * the [minWidth] and [minHeight] constraints are only applied when the incoming corresponding
 * constraint is `0.ipx`.
 * The modifier can be used, for example, to define a default min size of a component,
 * while still allowing it to be overidden with smaller min sizes across usages.
 *
 * Example usage:
 * @sample androidx.ui.layout.samples.DefaultMinSizeConstraintsSample
 */
fun Modifier.defaultMinSizeConstraints(
    minWidth: Dp = Dp.Unspecified,
    minHeight: Dp = Dp.Unspecified
) = this + UnspecifiedConstraintsModifier(minWidth, minHeight)

private data class FillModifier(private val direction: Direction) : LayoutModifier {

}

private data class SizeModifier(
    private val minWidth: Dp = Dp.Unspecified,
    private val minHeight: Dp = Dp.Unspecified,
    private val maxWidth: Dp = Dp.Unspecified,
    private val maxHeight: Dp = Dp.Unspecified,
    private val enforceIncoming: Boolean
) : LayoutModifier {
    private val Density.targetConstraints
        get() = Constraints(
            minWidth = if (minWidth != Dp.Unspecified) minWidth.toIntPx() else 0.ipx,
            minHeight = if (minHeight != Dp.Unspecified) minHeight.toIntPx() else 0.ipx,
            maxWidth = if (maxWidth != Dp.Unspecified) maxWidth.toIntPx() else IntPx.Infinity,
            maxHeight = if (maxHeight != Dp.Unspecified) maxHeight.toIntPx() else IntPx.Infinity
        )



}

private data class AlignmentModifier(
    private val alignment: Alignment,
    private val direction: Direction
) : LayoutModifier {

}

private data class UnspecifiedConstraintsModifier(
    val minWidth: Dp = Dp.Unspecified,
    val minHeight: Dp = Dp.Unspecified
) : LayoutModifier {

}

internal enum class Direction {
    Vertical, Horizontal, Both
}
